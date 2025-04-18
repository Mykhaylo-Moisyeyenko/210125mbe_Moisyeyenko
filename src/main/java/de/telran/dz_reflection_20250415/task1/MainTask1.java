package de.telran.dz_reflection_20250415.task1;

//1. При работе с NIO мы раньше использовали класс Files.
//Используя Reflection API исследуйте его и выведите на экран:
//        - все его конструкторы, вне зависимости от модификатора доступа;
// - все методы, вне зависимости от модификатора доступа;
// - все поля (характеристики), вне зависимости от модификатора доступа;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;

public class MainTask1 {
    public static void main(String[] args) {

        Class<?> clazz = Files.class;

        System.out.println("--------Name----------");
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());

        System.out.println("\n--------Constructors----------");
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor: constructors){
            System.out.println(constructor.getName());//найден всего один
        }

        System.out.println("\n--------Methods----------");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method: methods){
            System.out.println(method.getName());//найдено несколько десятков
        }

        System.out.println("\n--------Fields (characteristics)----------");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field: fields){
            System.out.println(field.getName());//найдено 4 поля
        }
    }
}
