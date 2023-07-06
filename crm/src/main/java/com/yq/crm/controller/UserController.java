package com.yq.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yq.crm.entity.User;
import com.yq.crm.service.UserService;
import com.yq.crm.vo.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
@RequiresRoles("董事长")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 查询用户列表
     *
     * @param
     * @return
     */
    @GetMapping("/list")
    @RequiresPermissions("用户列表")
    public String list(Model model,UserInfo userInfo) {
        IPage<User> userIPage = userService.findUsers(userInfo);
        model.addAttribute("userPage", userIPage);
        return "user/list";
    }

    @PostMapping("/ajaxlist")
    @ResponseBody
    @RequiresPermissions("用户列表")
    public IPage ajaxlist(UserInfo userInfo){
        IPage<User> userIPage = userService.findUsers(userInfo);
        System.out.println(userIPage);
        return userIPage;
    }

    /**
     * 进入修改信息页面
     *
     * @param model
     * @param usrId
     * @return
     */
    @GetMapping("/toedit")
    @RequiresPermissions("用户编辑")
    public String toedit(Model model, Long usrId) {
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
    @ResponseBody
    @RequiresPermissions("用户编辑")
    public int edit(User user) {
        int result = userService.updateUser(user);
        return result;
    }

    /**
     * 进入新增页面
     *
     * @return
     */
    @GetMapping("/toadd")
    @RequiresPermissions("用户新增")
    public String toadd() {
        return "user/add";
    }

    /**
     * 新增用户
     *
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    @RequiresPermissions("用户新增")
    public int add(User user) {
        int result = userService.addUser(user);
        return result;
    }

    /**
     * 删除用户
     *
     * @param usrId
     * @return
     */
    @GetMapping("/del")
    @ResponseBody
    @RequiresPermissions("用户删除")
    public int del(Long usrId) {
        int result = userService.deleteUser(usrId);
        return result;
    }
}
