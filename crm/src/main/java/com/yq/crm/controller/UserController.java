package com.yq.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yq.crm.entity.User;
import com.yq.crm.mapper.UserMapper;
import com.yq.crm.service.UserService;
import com.yq.crm.vo.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 进入登录页面
     *
     * @return
     */
    @GetMapping("/")
    String doLogin() {
        return "login";
    }

    /**
     * 登录
     *
     * @param model
     * @param name
     * @param pwd
     * @param session
     * @return
     */
    @PostMapping("/login")
    public String login(Model model, String name, String pwd, HttpSession session) {
//        通过shiro登录
        UsernamePasswordToken token = new UsernamePasswordToken(name, pwd);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            User user = (User) subject.getPrincipal();
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
        return "main";
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
    String main() {
        return "main";
    }

    /**
     * 查询用户列表
     *
     * @param model
     * @param usrId
     * @param usrName
     * @param current
     * @return
     */
    @GetMapping("/list")
    public String findUsers(Model model, Long usrId, String usrName, @RequestParam(defaultValue = "1", value = "current") Long current) {
        QueryWrapper wrapper = new QueryWrapper();
        //设置条件

        if (null != usrId) {
            //设置条件
            wrapper.eq("usr_id", usrId);
        }
        if (null != usrName) {
            //设置条件
            wrapper.eq("usr_name", usrName);
        }
        Page<User> page = new Page<>(current, 3); //设置分页
        IPage<User> userIPage = userService.findUsers(page, wrapper); //查询
        model.addAttribute("userPage", userIPage);
        return "user/list";
    }

    /**
     * 进入修改信息页面
     *
     * @param model
     * @param usrId
     * @return
     */
    @PostMapping("/toedit/{usrId}")
    String edit(Model model, @PathVariable("usrId") Long usrId) {
        User user = userService.findById(usrId);
        model.addAttribute("userTemp", user);
        return "user/edit";
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @PostMapping("/edit")
    String editSubmit(User user) {
        int result = userService.updateUser(user);
        return "{\"result\",\"" + result + "\"}";
    }

    /**
     * 进入新增页面
     *
     * @return
     */
    @GetMapping("/toadd")
    String toadd() {
        return "user/add";
    }

    /**
     * 新增用户
     *
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    String add(User user) {
        if (user != null) {
            int result = userService.addUser(user);
            if (result == 1) {
                return "{\"result\",\"11111\"}";
            } else {
                return "{\"result\",\"00000\"}";
            }
        } else {
            return "{\"result\",\"error\"}";
        }
    }

    /**
     * 删除用户
     *
     * @param usrId
     * @return
     */
    @PostMapping("/del/{usrId}")
    @ResponseBody
    String del(@PathVariable("usrId") Long usrId) {
        int result = userService.deleteUser(usrId);
        return "{\"result\",\"" + result + "\"}";
    }
}
