package com.yq.web;

import com.yq.comm.Info;
import com.yq.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//@PropertySource(value = "classpath:application.yml")
@EnableConfigurationProperties({Info.class})
@RestController
public class HelloController {

    @Resource
    private Info info;

    @Autowired
    private DemoService demoService;

    @RequestMapping("/hello")
    public String hello() {
        String msg = demoService.sayHello();
        msg += ",姓名：" + info.getName() + "邮箱:" + info.getEmail();
        return msg;
    }
}
