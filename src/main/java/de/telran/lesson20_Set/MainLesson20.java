package de.telran.lesson20_Set;

import java.util.*;

public class MainLesson20 {

    public static void main(String[] args) {

        List<Integer> one = Arrays.asList(3, 4, 5, 6, 73, 5, 7, 8, 4, 6, 8);
        List<Integer> two = Arrays.asList(5, 3, 5, 6, 7, 4, 7, 85, 4, 7, 9);

//вывести элементы, которые не дублируются в списках

        List<Integer> temp = new ArrayList(); //создаю временный Лист для всех цифр

        for (int i = 0; i < one.size(); i++) {//передаю в Лист первый набор чисел
            temp.add(one.get(i));
        }

        for (int i = 0; i < two.size(); i++) {//передаю в Лист второй набор чисел
            temp.add(two.get(i));
        }
        System.out.println("Объединенный список: " + temp);

        Set<Integer> tempSet = new HashSet<>();//создаю вспомогательный HashSet
        Set<Integer> duplicate = new HashSet<>();//создаю HashSet для дубликатов

        for (Integer a : temp) {
            if (!tempSet.add(a)){
                duplicate.add(a);//дубликаты откладываю
            } tempSet.add(a);//наполняю вспомогательный HashSet уникальными цифрами
        }
        System.out.println("Вспомогательный HashSet наполнен: " + tempSet);
        System.out.println("Дубликаты из списков: " + duplicate);

        List<Integer> finalList = new ArrayList(); //создаю финальный Лист для уникальных цифр

        for (Integer num : tempSet){
            if (!duplicate.contains(num)){
                finalList.add(num);
            }
        }
        System.out.println("Элементы, которые не дублируются в списках: " + finalList);
    }


    //        String str = "sjkdfkdshdskghdfkdslkjmsdcdksfsdfc";
//        System.out.println(str);
//
//        Set<Character> setString = new TreeSet();
//
//        for (int i = 0; i < str.length(); i++) {
//            setString.add(str.charAt(i));
//        }
//        System.out.println(setString);
}


