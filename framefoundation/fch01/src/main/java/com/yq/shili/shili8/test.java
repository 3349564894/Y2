package com.yq.shili.shili8;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        Class cls = Class.forName("com.yq.shili.shili1.Person");
        Object person = cls.newInstance();
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        System.out.println("赋值前的name:" + name.get(person));
        name.set(person, "New Person");
        System.out.println("赋值后的name:" + name.get(person));
    }
}
