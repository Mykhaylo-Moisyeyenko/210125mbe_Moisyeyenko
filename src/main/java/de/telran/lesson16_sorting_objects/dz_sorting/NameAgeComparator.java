package de.telran.lesson16_sorting_objects.dz_sorting;

import de.telran.lesson16_sorting_objects.Student;

import java.util.Comparator;

public class NameAgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int result = o1.getName().compareTo(o2.getName());
        if (result == 0){
            return o1.getAge()-o2.getAge();
        }
        //Сначала сравнивать имена и если они не равны, то использовать
        //результат сравнения имен
        //Если имена равны, то дополнительно сравнить возраст

        return  result;
    }
}
