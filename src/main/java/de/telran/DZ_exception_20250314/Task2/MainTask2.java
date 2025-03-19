package de.telran.DZ_exception_20250314.Task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTask2 {

    public static void main(String[] args) {

        try {
            boolean check = checkPassword("Misha", "1234567891011121314/", "12345678910111213141");
            System.out.println("Результаты проверки пароля: " + check);
        } catch (WrongPasswordException e) {//Обработка исключений проводится в вызывающем методе:
            System.out.println(e);
            System.out.println("Результаты проверки пароля: \n" + e);
        }
    }


    public static boolean checkPassword(String login, String password, String confirmPassword) throws WrongPasswordException {
//        2**) Должен содержать только латинские буквы, цифры.
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            throw new WrongPasswordException("Пароль содержит недопустимые символы");
        }
//1) Длина password должна быть меньше 20 символов.
        if (password.length() > 20) {
            throw new WrongPasswordException("Пароль содержит более 20 символов");
        }
        //Также password и confirmPassword должны быть равны.
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Подтверждение пароля не совпадает с паролем");
        }
        return true; //Метод возвращает true, если значения верны или false в другом случае.
    }

}
