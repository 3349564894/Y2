package com.yq.shili.shili4;

import com.yq.shili.shili1.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class test {
    public static void main(String[] args) {
        Field[] fields = Person.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("属性名：" + field.getName());
            System.out.println("属性类型：" + field.getType().getName());
            int modify = field.getModifiers();
            if ((modify & Modifier.PUBLIC) == Modifier.PUBLIC) {
                System.out.println("属性修饰符：public");
            }
            if ((modify & Modifier.PROTECTED) == Modifier.PROTECTED) {
                System.out.println("属性修饰符：PROTECTED");
            }
            if ((modify & Modifier.PRIVATE) == Modifier.PRIVATE) {
                System.out.println("属性修饰符：PRIVATE");
            }
            if ((modify & Modifier.STATIC) == Modifier.STATIC) {
                System.out.println("STATIC属性");
            }
            if ((modify & Modifier.FINAL) == Modifier.FINAL) {
                System.out.println("FINAL属性");
            }
            System.out.println("--------------------");
        }
    }
}
