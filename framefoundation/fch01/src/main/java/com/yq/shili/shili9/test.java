package com.yq.shili.shili9;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        Class cls = Class.forName("com.yq.shili.shili1.Person");
        Method getAge = cls.getDeclaredMethod("getAge", null);
        getAge.setAccessible(true);
        Object retunAge = getAge.invoke("silentMethod");
        System.out.println("年龄是：" + retunAge);
        Object person = cls.newInstance();

        Method sil = cls.getDeclaredMethod("setAddress", String.class);
        sil.setAccessible(true);
        sil.invoke(person, "郴州科泰");

        Method setName = cls.getDeclaredMethod("setName", String.class);
        setName.invoke(person, "New person");
        Object returnName = cls.getDeclaredMethod("getName").invoke(person);
        System.out.println("name的值" + returnName);
    }
}
