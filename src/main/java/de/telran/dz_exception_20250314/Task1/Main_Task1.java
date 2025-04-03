package de.telran.dz_exception_20250314.Task1;

//Создайте метод, в который передается строка e-mail и он проверяет его на правильность
//по условию:
//        - строка должна содержать @
//- строка должно содержать хотя бы один символ "точка"
//Если условия не соблюдаются - метод выбрасывает встроенное исключение IllegalArgumentException.

import java.util.Scanner;

public class Main_Task1 {

    public static void main(String[] args) {

        try {
            checkEmails();
        } catch (IllegalArgumentException e){
            System.out.println(e);
        }

    }

    public static void checkEmails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите e-mail: ");
        String email = scanner.nextLine();

        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("В вашем e-mail отсутствует @ или точка.");
        } else {
            System.out.println("Email введен корректно, спасибо");
        }
    }


}
