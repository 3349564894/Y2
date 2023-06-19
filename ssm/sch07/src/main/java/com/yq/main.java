package com.yq;

import com.yq.dao.SysUserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        SysUserMapper mapper = (SysUserMapper) ctx.getBean("SysUserService");
        System.out.println(mapper.findUser());
    }
}
