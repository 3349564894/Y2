package com.yq.shili.shili7;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class cls = Class.forName("com.yq.shili.shili1.Person");
        Constructor c1 = cls.getDeclaredConstructor();
        Object obj = c1.newInstance();
        System.out.println(obj);

        Constructor c2 = cls.getDeclaredConstructor(String.class);
        //该构造方法为private，无法访问，使用setAccessible方法设置可以访问
        c2.setAccessible(true);
        Object obj1 = c2.newInstance("New Person");
        System.out.println(obj1);

        Constructor c3 = cls.getDeclaredConstructor(String.class, String.class, String.class);
        //该构造方法为protected，无法访问，使用setAccessible方法设置可以访问
        c3.setAccessible(true);
        Object obj2 = c3.newInstance("New Person", "beijing", "Hello");
        System.out.println(obj2);
    }
}
