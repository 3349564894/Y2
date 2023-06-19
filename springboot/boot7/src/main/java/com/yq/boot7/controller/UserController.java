package com.yq.boot7.controller;

import com.yq.crm.entity.User;
import com.yq.crm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/")
    String doLogin() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model, String name, String pwd, HttpSession session) {
        User user = userService.findUser(name, pwd);
        if (user != null) {
            session.setAttribute("user", user);
        return "main";
        } else {
            model.addAttribute("message", "账号或密码错误！");
            return "login";
        }
    }

    @GetMapping("/main")
    String main() {
        return "main";
    }

    @GetMapping("/list")
    String findUsers(Model model, Integer usrId, String usrName, Long current) {
//        QueryWrapper wrapper = new QueryWrapper();
//        //设置条件
//        wrapper.eq("usr_id",usrId);
//        if (usrName != null || !usrName.equals("")){
//            //设置条件
//            wrapper.eq("usr_name",usrName);
//        }
//        Page<User> page = new Page<>(current,3); //设置分页
//        IPage<User> userIPage = userService.selectPage(page,wrapper); //查询
//        model.addAttribute("userPage",userIPage);
        return "user/list";
    }

    @PostMapping("/list/find")
    String findUsersAndCondition(Model model, String param1, String param2) {
        return "user/list";
    }

    @GetMapping("/edit")
    String edit() {
        return "user/edit";
    }

    @PostMapping("/edit/submit")
    String editSubmit(User user) {
        return "";
    }

    @GetMapping("/add")
    String add() {
        return "user/add";
    }

    @PostMapping("/add/submit")
    String addSubmit() {
        return "";
    }
}
