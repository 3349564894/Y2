package com.yq.crm.config.shiro;

import com.yq.crm.entity.Right;
import com.yq.crm.entity.Role;
import com.yq.crm.entity.RoleRight;
import com.yq.crm.entity.User;
import com.yq.crm.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.Set;

public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权。。。。");
        User loginUser = (User) principalCollection.getPrimaryPrincipal();//身份
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //静态授权：授予主体响应的角色和权限
//        info.addRole(loginUser.getRole().getRoleName());//角色
//        //权限
//        info.addStringPermission("用户列表");
//        if("董事长".equals(loginUser.getRole().getRoleName())){
//            info.addStringPermission("用户新增");
//            info.addStringPermission("用户编辑");
//            info.addStringPermission("用户删除");
//        }else if ("管理员".equals(loginUser.getRole().getRoleName())){
//            info.addStringPermission("用户新增");
//            info.addStringPermission("用户编辑");
//            info.addStringPermission("用户删除");
//        }
        //动态授权
        Role role = loginUser.getRole();
        if (role != null) {
            info.addRole(loginUser.getRole().getRoleName());
            Set<RoleRight> roleRights = role.getRoleRights();
            if (roleRights != null && roleRights.size() != 0) {
                for (RoleRight roleRight : roleRights) {
                    for (Right right : roleRight.getRights()) {
                        info.addStringPermission(right.getRightCode());
                    }

                }
            }
        }
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("进入认证----------");
        //获取用户信息==》token
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //方法调用
        String name = token.getUsername();
        User loginUser = userService.findByName(name);
        if (loginUser == null) {
            //不存在
            System.out.println("未知的账号异常");
            throw new UnknownAccountException();//未知的账号异常
        }
        if (loginUser.getUsrFlag() != null && loginUser.getUsrFlag() != 0) {//账户异常
            //异常
            throw new LockedAccountException();//账号锁定
        }
        //密码校验
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                loginUser, //身份
                loginUser.getUsrPassword(), //凭证
                this.getName()); //realm名称
        return info;
    }
}
