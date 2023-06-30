package com.yq.crm.config.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public MyShiroRealm myShiroRealm() {
        return new MyShiroRealm();
    }

    @Bean
    public SecurityManager securityManager() { //注意package
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //创建 注入的realm（安全数据源）
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        return shiroFilterFactoryBean;
    }

    //    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBeann = new ShiroFilterFactoryBean();
        //4、将SecurityManager添加到安全对象中
        shiroFilterFactoryBeann.setSecurityManager(securityManager);

        //设置请求权限控制
        shiroFilterFactoryBeann.setLoginUrl("/");
//        shiroFilterFactoryBeann.setSuccessUrl("/main");
        shiroFilterFactoryBeann.setUnauthorizedUrl("/403");

        Map<String, String> chainMap = new LinkedHashMap<String, String>();//必须使用 LinkedHashMap(有序集合)
        //1、添加白名单==》不需要权限管理的请求==》资源文件==>static中有多少个文件夹，就配置多少
        chainMap.put("/css/**", "anon");
        chainMap.put("/images/**", "anon");
        chainMap.put("/js/**", "anon");
        chainMap.put("/localcss/**", "anon");
        chainMap.put("/localjs/**", "anon");
//        chainMap.put("/user/doLogin", "anon"); //登入提交请求
//        chainMap.put("/user/logout", "anon"); //退出请求
        chainMap.put("/main", "anon"); //退出请求

        //2、添加特定权限可访问的资源==>controller中的所有请求【登入和退出除外】
//        chainMap.put("/chance/list","perms[销售机会列表]");
//        chainMap.put("/chance/toadd","perms[销售机会新增页面]");
//        chainMap.put("/chance/add","perms[销售机会新增]");
//        chainMap.put("/chance/toedit","perms[销售机会编辑页面]");
//        chainMap.put("/chance/edit","perms[销售机会新编辑]");
//        chainMap.put("/chance/del","perms[销售机会删除]");

//        chainMap.put("/plan/list","perms[计划列表]");
//        chainMap.put("/plan/toadd","perms[计划新增页面]");
//        chainMap.put("/plan/add","perms[计划新增]");
//        chainMap.put("/plan/toedit","perms[计划编辑页面]");
//        chainMap.put("/plan/edit","perms[计划编辑]");
//        chainMap.put("/plan/del","perms[计划删除]");

//        chainMap.put("/plan/list","perms[计划列表]");
//        chainMap.put("/plan/toadd","perms[计划新增页面]");
//        chainMap.put("/plan/add","perms[计划新增]");
//        chainMap.put("/plan/toedit","perms[计划编辑页面]");
//        chainMap.put("/plan/edit","perms[计划编辑]");
//        chainMap.put("/plan/del","perms[计划删除]");

        //其他未知请求，必须认证通过才能进入
//        chainMap.put("/**", "authc");

        shiroFilterFactoryBeann.setFilterChainDefinitionMap(chainMap);
        return shiroFilterFactoryBeann;
    }

    @Bean(name = "shiroDialect")
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}