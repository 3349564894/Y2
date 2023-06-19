package com.yq.shili.shili3;

import com.yq.shili.shili1.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class test {
    public static void main(String[] args) {
        Constructor[] cons = Person.class.getDeclaredConstructors();
        System.out.println("==========构造方法展示========");
        for (Constructor con : cons) {
            int modify = con.getModifiers();
            System.out.println("访问修饰符");
            if ((modify & Modifier.PUBLIC) == Modifier.PUBLIC) {
                System.out.println(con + "构造方法的修饰符public");
            } else if ((modify & Modifier.PROTECTED) == Modifier.PROTECTED) {
                System.out.println(con + "构造方法的修饰符protected");
            } else if ((modify & Modifier.PRIVATE) == Modifier.PRIVATE) {
                System.out.println(con + "构造方法的修饰符private");
            } else {
                System.out.println(con + "构造方法的修饰符default");
            }

            //获取构造方法的参数列表
            Class[] params = con.getParameterTypes();
            if (params.length == 0) {
                System.out.println("该构造方法没有参数");
            } else {
                System.out.println("该构造方法参数列表[:");
                for (int i = 0; i < params.length; i++) {
                    if (i != 0) {
                        System.out.println(",");
                    }
                    System.out.println(params[i].getName());
                }
                System.out.println("]");
            }
            System.out.println("-----------------------");
        }
    }
}
