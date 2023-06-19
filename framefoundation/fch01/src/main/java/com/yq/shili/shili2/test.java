package com.yq.shili.shili2;

import com.yq.shili.shili1.Person;

import java.lang.reflect.Modifier;

public class test {
    public static void main(String[] args) {
        Class cls = Person.class; //获取类的名称
        String fullName = cls.getName(); //获取该类型的名称
        String simpleName = cls.getSimpleName(); //获取该类型的简称
        System.out.println("以下是" + fullName + "类的基本信息");
        System.out.println("---------------------------------------");
        //获取Person类所在的包
        Package pkg = cls.getPackage();
        System.out.println(simpleName + "类定义在" + pkg.getName() + "包中");
        System.out.println("---------------------------------------");
        //获取超类名称
        Class superClass = cls.getSuperclass();
        System.out.println(simpleName + "类的超类是:" + superClass.getName());
        System.out.println("---------------------------------------");
        //获取实现的接口名
        Class[] interfaces = cls.getInterfaces();
        System.out.println(simpleName + "类所实现的接口：");
        for (Class c : interfaces) {
            System.out.println("\t" + c.getName());
        }
        System.out.println("---------------------------------------");
        //获取该类的所有修饰符
        int modifier = cls.getModifiers();
        System.out.println(simpleName + "类的修饰符");
        if ((modifier & Modifier.PUBLIC) == Modifier.PUBLIC)
            System.out.println(simpleName + "类的访问修饰符是public");
        else
            System.out.println(simpleName + "类的访问修饰符是default(package)");
        if ((modifier & Modifier.FINAL) == Modifier.FINAL)
            System.out.println(simpleName + "类是final的");
        if ((modifier & Modifier.STATIC) == Modifier.STATIC)
            System.out.println(simpleName + "类是static的");
        if ((modifier & Modifier.INTERFACE) == Modifier.INTERFACE)
            System.out.println(simpleName + "是一个接口");
        System.out.println("---------------------------------------");

    }
}
