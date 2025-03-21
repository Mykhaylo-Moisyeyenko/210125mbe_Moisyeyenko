package de.telran.DZ_regex_20250318.Task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_Task1 {

//    1. Написать регулярное выражение для проверка email (например my_25@domen-38.de).

    public static void main(String[] args) {
        String email = new String("my_25@domen-38.de");
        Pattern pattern = Pattern.compile(".+@.+\\.de$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            System.out.println("Пароль введен корректно");
        } else System.out.println("Пароль введен некорректно");
    }


}
