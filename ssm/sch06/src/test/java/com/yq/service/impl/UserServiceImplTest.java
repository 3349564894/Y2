package com.yq.service.impl;

import com.yq.entity.TestEntity;
import com.yq.entity.User;
import com.yq.service.UserService;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.beans.Expression;
import java.util.HashMap;
import java.util.Iterator;

public class UserServiceImplTest extends TestCase {

    public void testSave() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = (UserService) context.getBean("userService");
        User user = new User();
        user.setUserNo(1);
        user.setUserName("小明");
        user.setPassword("123456");
        user.setAge(18);
        user.setEmail("334956894@qq.com");
        user.setPhone("19158068081");
        user.setSex('男');
        userService.save(user);
//        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
//        TestEntity entity = (TestEntity) context.getBean("testEntity");
//        System.out.println("空赋值:" + entity.getEmptyValue());
//        System.out.println("null赋值:" + entity.getNullValue());
//        System.out.println("特殊字符赋值1：" + entity.getSpecialCharacter1().trim());
//        System.out.println("特殊字符赋值2：" + entity.getSpecialCharacter2().trim());
//        System.out.print("数组赋值：");
//        for (int i = 0; i < entity.getArray().length; i++) {
//            if (i == entity.getArray().length - 1) {
//                System.out.println(entity.getArray()[i]);
//            } else {
//                System.out.print(entity.getArray()[i] + ",");
//            }
//        }
//        System.out.println("list赋值:");
//        for (int i = 0; i < entity.getList().size(); i++) {
//            if (i == entity.getList().size() - 1) {
//                System.out.println(entity.getList().get(i));
//            } else {
//                System.out.println(entity.getList().get(i));
//            }
//        }
//        Iterator iterator = entity.getSet().iterator();
//        while(iterator.hasNext()){
//            System.out.println("set赋值:"+iterator.next());
//        }
//        System.out.println("map赋值:"+entity.getMap().get("key1"));
//        System.out.println("map赋值:"+entity.getMap().get("key2"));
//        System.out.println("map赋值:"+entity.getMap().get("key3"));
//        System.out.println("类赋值"+entity.getUser().getClass().getName());
//        System.out.println("properties赋值"+entity.getProperties().getProperty("key1"));
//        System.out.println("properties赋值"+entity.getProperties().getProperty("key2"));
//        System.out.println("properties赋值"+entity.getProperties().getProperty("key3"));
    }
}