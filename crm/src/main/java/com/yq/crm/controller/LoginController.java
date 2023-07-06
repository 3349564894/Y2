package com.yq.crm.controller;

import com.yq.crm.entity.Right;
import com.yq.crm.entity.Role;
import com.yq.crm.entity.User;
import com.yq.crm.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Resource
    private RoleService roleService;

    /**
     * 进入登录页面
     *
     * @return
     */
    @GetMapping("/")
    public String doLogin() {
        return "login";
    }

    /**
     * 登录
     *
     * @param model
     * @param usrname
     * @param usrpassword
     * @param session
     * @return
     */
    @PostMapping("/login")
    public String login(Model model, HttpSession session, String usrname, String usrpassword) {
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(usrname, usrpassword);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token); //登录
            User user = (User) subject.getPrincipal(); //登录成功
//            Role role = user.getRole();
//            List<Right> rights = roleService.findRightByRole(role); //查询权限
//            role.getRights().addAll(rights);
            session.setAttribute("user", user);
        } catch (UnknownAccountException e) {
            System.out.println("账号不存在");
            model.addAttribute("message", "账号不存在");
            return "login";
        } catch (LockedAccountException e1) {
            System.out.println("账号被锁定");
            model.addAttribute("message", "账号被锁定");
            return "login";
        }
        return "redirect:main";
    }

    /**
     * 登出
     *
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }

    /**
     * 进入系统主页
     *
     * @return
     */
    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/403")
    public String quanxian(){
        return "403";
    }
}
