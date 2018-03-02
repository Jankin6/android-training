package com.wangjj.android_training.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wangjianjun on 17/4/1.
 */

public class ReflectionTest {

    public static void main(String[] args){

        // 获取class对象的三种方式
        Class clazz = Dog.class;

        Dog dog = new Dog("小黄");
        Class clazz2 = dog.getClass();

        try {
            Class clazz3 = Class.forName("com.wangjj.android_training.reflection.Dog");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 通过class对象构造目标类型对象
        try {
            // 这里需要传递参数的类型
            Constructor constructor = clazz.getConstructor(String.class);
            Dog mydog = (Dog) constructor.newInstance("大黄");
            System.out.println(mydog.getName());

            // 当你通过反射获取到 Constructor、Method、Field 后，在反射调用之前将此对象的 accessible 标志设置为 true，以此来提升反射速度。值为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查。
            Method method = clazz2.getDeclaredMethod("setWeight", int.class);
            method.setAccessible(true);
            method.invoke(mydog, 2);
            System.out.println(mydog.getWeight());

            // 反射获取类中函数
            // 获取当前类中定义的方法 它会获取到当前类中的 public、default、protected、private 的所有方法
            Method[] methods = clazz2.getDeclaredMethods();
            for (Method myMethod : methods) {
                System.out.println("declared method name : "+ myMethod.getName());
            }

            // 获取当前类以及父类中的所有 public 方法
            Method[] methods2 = clazz2.getMethods();
            for (Method myMethod : methods2) {
                System.out.println("public method name : "+ myMethod.getName());
            }

            // 获取当前类中定义的属性
            Field[] fields = clazz2.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("declared field name : "+ field.getName());
            }

            // 获取当前类、父类中定义的公有属性
            Field[] fields2 = clazz2.getFields();
            for (Field field : fields2) {
                System.out.println("public field name : "+ field.getName());
            }

            Field field = clazz2.getDeclaredField("weight");
            field.setAccessible(true);
            System.out.println("origin weight : "+ field.getInt(mydog));
            field.set(mydog, 100);
            System.out.println("set weight : "+ field.getInt(mydog));

            // 获取 Class 对象的父类
            Class<?> superClass = clazz2.getSuperclass();
            while (superClass != null) {
                System.out.println("dog's super class is : " + superClass.getName());
                // 再获取父类的上一层父类，直到最后的 Object 类，Object 的父类为 null
                superClass = superClass.getSuperclass();
            }

            // 获取接口
            Class[] interfaces = clazz2.getInterfaces();
            for (Class anInterface : interfaces) {
                System.out.println("interface : "+ anInterface.getName());

            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }
}
