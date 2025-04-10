package de.telran.lesson22;

import java.util.HashMap;
import java.util.Map;

public class MainLesson22 {

    public static void main(String[] args) {

        String text = "sdfsdfsdgksdgkjdhgkjsdhgksjhfksfjkslfslgsdgljsklghslk";
//вывести буквы из которых состоит строка (без дубликатов)
// и посчитать количество вхождений каждой буквы в эту строк
// s - 7
// d - 4
// f - 5

        System.out.println(text);

        Map<Character, Integer> hashMapString = new HashMap();

        for (int i = 0; i < text.length(); i++) {
            hashMapString.put(text.charAt(i), i+=1);
        }
        System.out.println(hashMapString);




        for (int i = 0; i < text.length(); i++) {
            if (hashMapString.put(text.charAt(i), i+=1)==null){



            };
        }
        System.out.println(hashMapString);


    }


}
