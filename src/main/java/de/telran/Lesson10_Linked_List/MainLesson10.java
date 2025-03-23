package de.telran.Lesson10_Linked_List;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainLesson10 {

    public static void main(String[] args) {

        Random random = new Random();
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(random.nextInt(500));
        }

        maxElement(integers);
        minElement(integers);
        listBack(integers);
        divideList (integers);

    }

    //1. Найти максимальный элемент в списке
    public static void maxElement(List<Integer> integers) {
        int max = integers.get(0);
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) > max) {
                max = integers.get(i);
            }
        }
        System.out.println("Максимальный элемент: " + max);
    }

    //    2 найти минимальный элемент в списке
    public static void minElement(List<Integer> integers) {
        int min = integers.get(0);
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) < min) {
                min = integers.get(i);
            }
        }
        System.out.println("Минимальный элемент: " + min);
    }

    //    3 вывести список в обратном порядке
    public static void listBack(List<Integer> integers) {
        for (int i = integers.size()-1; i >= 0; i--) {
            System.out.println("Элемент списка с индексом "+ i + " " + integers.get(i));
        }
    }

//    /4 поделить список на два списка - четные и нечетные
    public static void divideList (List<Integer> integers){
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();

        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i)%2 == 0){
                evenList.add(integers.get(i));
            } else {
                oddList.add(integers.get(i));
            }
        }
        System.out.println("Список с четными числами: " +evenList);
        System.out.println("Список с нечетными числами: " +oddList);
    }

}
