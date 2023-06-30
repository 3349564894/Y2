package com.yq.crm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yq.crm.entity.User;
import com.yq.crm.mapper.UserMapper;
import com.yq.crm.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CrmApplicationTests {
    @Resource
    private UserService userService;

    @Test
    public void testShiro() {
//        //前期准备工作==》配置
//        //1、创建Realm【安全数据源】
//        IniRealm realm = new IniRealm("classpath:shiro.ini");
//        //2、配置SecurityManager 安全管理器
//        DefaultSecurityManager securityManager = new DefaultSecurityManager();
//        //3、将创建的Realm添加到SecurityManager
//        securityManager.setRealm(realm);
//        //4、将SecurityManager添加到安全对象中
//        SecurityUtils.setSecurityManager(securityManager);
//
//        //准备后：认证==》程序员干活
//        //1、创建subject
//        Subject subject = SecurityUtils.getSubject();
//        //2、封装到 UsernamePasswordToken
//        UsernamePasswordToken token = new UsernamePasswordToken("admin", "123456");
//        //3、登入
//        try {
//            subject.login(token);  //原来：传入账号 / 密码==》调用dao==》到数据库中匹配
//        } catch (AuthenticationException e) {
//            //4、如果异常==》认证失败==》身份/凭证 错误
//            e.printStackTrace();
//        }
//        //4、如果正常
//        System.out.println("认证:" + subject.isAuthenticated());
//
//        //授权
//        System.out.println("角色：" + subject.hasRole("董事长"));
//        System.out.println("验证权限：" + subject.isPermitted("user:list"));
//        //使用check方法判断是否拥有某权限，但是失败会抛出异常:UnauthorizedException
//        subject.checkPermission("dict:list");
        System.out.println(userService.findUser("admin", "123456").getRole().getRoleName());
    }

}
