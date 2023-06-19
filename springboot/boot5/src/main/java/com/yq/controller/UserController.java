package com.yq.controller;


import com.yq.pojo.User;
import com.yq.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/doLogin")
    public String doLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("usrName") String usrName, @RequestParam("usrPassword") String usrPassword, Model model, HttpSession session) {
        System.out.println(usrName + ",psw" + usrPassword);
        User user = userService.login(usrName, usrPassword);
        if (user != null) {
            session.setAttribute("loginUser", user);
            return "main";
        } else {
            model.addAttribute("error", "账号或密码错误");
            return "login";
        }
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long usrId) {
        User user = userService.getUser(usrId);
        return user;
    }

    @GetMapping("/users")
    public List<User> getUserList() {
        List<User> userList = userService.findUserList();
        return userList;
    }

    @PostMapping("/user")
    public void addUser(User user) {
        userService.add(user);
    }

    @PutMapping("/user")
    public void updateUser(User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") Long usrId) {
        userService.remove(usrId);
    }
}
