package com.yq.controller;

import com.yq.entity.User;
import com.yq.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户登录
     *
     * @param model
     * @param session
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String doLogin(Model model, HttpSession session, @RequestParam(required = false) String account, @RequestParam(required = false) String password) {
        User user = userService.findUser(account);
        if (account == null || account.equals("") && password.equals("") || password == null) {

        } else if (user == null) {
            model.addAttribute("error1", "账号错误");
            return "login";
        } else if (!user.getPassword().equals(password)) {
            model.addAttribute("error2", "密码错误");
            return "login";
        } else {
            session.setAttribute("user", user);
            return "frame";
        }
        return null;
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }

    @RequestMapping(value = "/frame")
    public String frame() {
        return "frame";
    }

    @RequestMapping("/user/list")
    public void findUserList(HttpSession session) {
        List<User> list = userService.findUserList();
        session.setAttribute("userList", list);
    }

    @RequestMapping("/user/updatePassword")
    public void changePassword(HttpSession session, @RequestParam(required = false) String account, @RequestParam(required = false) String newPassword) {

    }
}
