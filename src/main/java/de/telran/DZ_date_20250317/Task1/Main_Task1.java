package de.telran.DZ_date_20250317.Task1;

//1) реализовать метод, который принимает год и проверяет на высокосность
//2) вывести на консоль дату локализованную для Индии (например)
//3) вывести дату в формате 19-12-22, 19, 353, 11:47 <дата, день месяца, день в году, время>
//4) создать дату своего рождения, вывести на консоль в формате "10 Января 1985"
//5) проверить дата "10 Января 1985" - это пятница, попробуйте получить день недели для любой другой даты?
//6) вычесть 10 лет из созданной даты, вывести на консоль
//7) получить обьект Instant из "2022-12-19T06:55:30.00Z", вывести на консоль
//8) получить ZonedDateTime из "Pacific/Midway", вывести на консоль

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Scanner;

public class Main_Task1 {

    public static void main(String[] args) {

//        checkYear(); //1) реализовать метод, который принимает год и проверяет на высокосность
//
//        //2) вывести на консоль дату локализованную для Индии (например)
//        ZoneId zoneId = ZoneId.of("Asia/Kolkata");
//        ZonedDateTime zoneDateTime = ZonedDateTime.now(zoneId);
//        System.out.println("Дата, локализованная для Индии: " +zoneDateTime);;

//        //3) вывести дату в формате 19-12-22, 19, 353, 11:47 <дата, день месяца, день в году, время>
//        LocalDateTime date3 = LocalDateTime.now();
//        System.out.println("Исходная дата: " +date3);
//        int dateOfMonth3 = date3.getDayOfMonth();
//        int month3 = date3.getMonthValue();
//        int year3 = date3.getYear();
//        int dayOfYear3 = date3.getDayOfYear();
//        int hour3 = date3.getHour();
//        int min3 = date3.getMinute();
//        System.out.printf("Форматированный вывод даты = %d-%d-%d, %d, %d, %d:%d \n", dateOfMonth3, month3, year3, dateOfMonth3, dayOfYear3, hour3, min3); //шаблонизированный вывод в консоль

//4) создать дату своего рождения, вывести на консоль в формате "10 Января 1985
        LocalDate dateMyBirthday4 = LocalDate.of(1976, 09, 07);
        //System.out.printf("Форматированный вывод даты = %d-%d-%d, %d, %d, %d:%d \n", dateOfMonth3, month3, year3, dateOfMonth3, dayOfYear3, hour3, min3); //шаблонизированный вывод в консоль








    }

    public static void checkYear() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите год: ");
        int year = scanner.nextInt();
        LocalDate date = LocalDate.of(year, 1, 1);
        boolean isLeap = date.isLeapYear();
        if (isLeap) {
            System.out.println("Этот год - високосный");
        } else {
            System.out.println("Этот год - не високосный");
        }


    }

}
