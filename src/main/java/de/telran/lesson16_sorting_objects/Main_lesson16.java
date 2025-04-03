package de.telran.lesson16_sorting_objects;

import de.telran.lesson16_sorting_objects.dz_sorting.NameAgeComparator;

import java.util.*;

public class Main_lesson16 {

    public static void main(String[] args) {

        Student alex = new Student("Alex", 25);
        Student oleg = new Student("Max", 20);
        Student max = new Student("Max", 18);

        List<Student> students = new ArrayList<>();
        students.add(alex);
        students.add(oleg);
        students.add(max);

        Comparator<Student> comparator = new NameAgeComparator();
        List<Student> students2 = new ArrayList<>(students); // чтобы сохранился исходный список, а сортировалось в новом списке
        Collections.sort(students, comparator);
        System.out.println(students);
    }
}
