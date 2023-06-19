package com.yq.shili.shili5;

import com.yq.shili.shili1.Person;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class test {
    public static void main(String[] args) {
        Method[] methods = Person.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("方法名：" + method.getName());
            System.out.println("返回值类型：" + method.getReturnType());
            int modify = method.getModifiers();
            System.out.println("访问修饰符");
            if ((modify & Modifier.PUBLIC) == Modifier.PUBLIC) {
                System.out.println("方法的修饰符public");
            } else if ((modify & Modifier.PROTECTED) == Modifier.PROTECTED) {
                System.out.println("方法的修饰符protected");
            } else if ((modify & Modifier.PRIVATE) == Modifier.PRIVATE) {
                System.out.println("方法的修饰符private");
            } else {
                System.out.println("方法的修饰符default");
            }
            Class[] params = method.getParameterTypes();
            if (params.length == 0) {
                System.out.println("该构造方法没有参数");
            } else {
                System.out.println("该构造方法参数列表[");
                for (int i = 0; i < params.length; i++) {
                    if (i != 0) {
                        System.out.println(",");
                    }
                    System.out.println(params[i].getName());
                }
                System.out.println("]");
            }
            System.out.println("-----------------------");
            Class dec = method.getDeclaringClass();
            System.out.println("方法声明在：" + dec.getName());
            Class[] ex = method.getExceptionTypes();
            if (ex.length > 0) {
                System.out.println("该方法抛出的异常有：[");
                for (int i = 0; i < ex.length; i++) {
                    if (i != 0) {
                        System.out.println(",");
                    }
                    System.out.println(ex[i].getName());
                }
                System.out.println("]");
            }
        }
    }
}
