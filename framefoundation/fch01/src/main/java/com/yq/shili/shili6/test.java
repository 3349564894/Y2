package com.yq.shili.shili6;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class cls = Class.forName("com.yq.shili.shili1.Person");
        Object obj = cls.newInstance(); //创建实例
        System.out.println(obj);
    }
}
