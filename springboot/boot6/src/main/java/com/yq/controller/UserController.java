package com.yq.controller;


import com.yq.pojo.User;
import com.yq.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
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
    public String login(@Param("usrName") String usrName, @Param("usrPassword") String usrPassword, Model model, HttpSession session) {
        System.out.println(usrName + ",psw" + usrPassword);
        User user = userService.login(usrName, usrPassword);
        if (user != null) {
            session.setAttribute("loginUser", user);
            return "redirect:/main";
        } else {
            model.addAttribute("error", "账号或密码错误");
            return "login";
        }
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/hello/{id}")
    public String getUser(Model model, @PathVariable("id") Long usrId) {
//        User user = userService.getUser(usrId);
        List<User> userList = userService.findAllUsers();
        model.addAttribute("flag", userList);
        return "demo/hello";
    }

    @GetMapping("/index")
    String index() {
        return "demo/index";
    }

    @GetMapping("/users")
    public List<User> getUserList() {
        List<User> userList = userService.findAllUsers();
        return userList;
    }

    @PostMapping("/user")
    public void addUser(User user) {
        userService.addUser(user);
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
