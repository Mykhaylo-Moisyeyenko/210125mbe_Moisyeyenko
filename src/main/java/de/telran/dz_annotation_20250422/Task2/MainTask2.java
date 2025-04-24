package de.telran.dz_annotation_20250422.Task2;

//2*. Для первой задачи напишите программу, которая с помощью Reflection API сможет
//найти все участки кода, которые помечены пользовательской аннотацией и выведет
//информацию в виде списка необходимых доработок в формате:
//Имя метода/класса/характеристики, ФИО ревьювера, Комментарий.

import de.telran.dz_annotation_20250422.Task1.ClassForAnnotations;
import de.telran.dz_annotation_20250422.Task1.MyAnnotationsTask1;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainTask2 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        //Исследую класс, чтобы найти интерфейс аннотаций:
        Class<ClassForAnnotations> clazz = ClassForAnnotations.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation anno : annotations) {
            System.out.println("Interface name: " + anno.annotationType().getSimpleName() + "\n");
        }

        //Исследую интерфейс аннотаций:
        Class<MyAnnotationsTask1> myAnnotationsTask1Clazz = MyAnnotationsTask1.class;
        annotations = myAnnotationsTask1Clazz.getAnnotations();
        for (Annotation anno : annotations) {
            System.out.println("Annotation of interface MyAnnotationsTask1: " + anno.annotationType().getSimpleName());
        }

        //Выясняю уровень аннотации Retention:
        System.out.println("\nУровень аннотации Retention: "
                + myAnnotationsTask1Clazz.getAnnotation(Retention.class).value());

        //Выясняю на что распространяются аннотации (Target):
        System.out.println("\nНа что распространяется интерфейс MyAnnotationsTask1: "
                + myAnnotationsTask1Clazz.getAnnotation(Target.class) + "\n");
        // получен результат: Target({TYPE, FIELD, CONSTRUCTOR, METHOD})

        //Выясняю какие поля(методы) есть у интерфейса MyAnnotationsTask1:
        Method[] methods = myAnnotationsTask1Clazz.getMethods();
        for (Method m : methods) {
            System.out.println("Поля интерфейса MyAnnotationsTask1: " + m.getName());
        } //найдены три поля: fio, nummer, value

        //распечатываю аннотации к классу:
        if (clazz.isAnnotationPresent(myAnnotationsTask1Clazz)) {
            MyAnnotationsTask1 annotationsTask1 = clazz.getAnnotation(myAnnotationsTask1Clazz);
            System.out.println("\nАннотации к классу ClassForAnnotations: \n"
                    + annotationsTask1.reviewer() + ", "
                    + annotationsTask1.comment());
        }

        //распечатываю аннотации к конструкторам:
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            if (constructor.isAnnotationPresent(myAnnotationsTask1Clazz)) {
                MyAnnotationsTask1 annotationsTask1 = (MyAnnotationsTask1) constructor.getAnnotation(myAnnotationsTask1Clazz);
                System.out.println("\nАннотации к конструктору " + constructor.getName() + ": \n"
                        + annotationsTask1.reviewer() + ", "
                        + annotationsTask1.comment());
            }
        }

        //распечатываю аннотации к методам:
        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method method : methods1) {
            if (method.isAnnotationPresent(myAnnotationsTask1Clazz)) {
                MyAnnotationsTask1 annotationsTask1 = method.getAnnotation(myAnnotationsTask1Clazz);
                System.out.println("\nАннотации к методу " + method.getName() + ": \n"
                        + annotationsTask1.reviewer() + ", "
                        + annotationsTask1.comment());
            }
        }

        //распечатываю аннотации к полям:
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(myAnnotationsTask1Clazz)) {
                MyAnnotationsTask1 annotationsTask1 = field.getAnnotation(myAnnotationsTask1Clazz);
                System.out.println("\nАннотации к методу " + field.getName() + ": \n"
                        + annotationsTask1.reviewer() + ", "
                        + annotationsTask1.comment());
            }
        }
    }
}
