package com.yq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class HelloController {
    @GetMapping(value = "/hello")
    public ModelAndView hello(@RequestParam(defaultValue = "啦啦啦", required = false) String realName) throws Exception {
        System.out.println("Spring-MVC框架搭建成功1");
        System.out.println("realName=" + realName);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("realName", realName);
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello1(Model model, @RequestParam(defaultValue = "啦啦啦") String realName) throws Exception {
        System.out.println("Spring-MVC框架搭建成功2");
        model.addAttribute(realName);
        return "hello1";
    }

    @RequestMapping(value = "/hello2")
    public String hello2(Map<String, Object> map, @RequestParam(defaultValue = "ok") String realName) throws Exception {
        System.out.println("Spring-MVC框架搭建成功3,realName=" + realName);
        map.put("realName", realName);
        return "hello2";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(Model model, @RequestParam String account) throws Exception {
        System.out.println("ok");
        model.addAttribute("account", account);
        return "show";
    }
}
