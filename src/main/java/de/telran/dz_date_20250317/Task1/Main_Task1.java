package de.telran.dz_date_20250317.Task1;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main_Task1 {

    public static void main(String[] args) {

        //1) реализовать метод, который принимает год и проверяет на высокосность
        checkYear();

        //2) вывести на консоль дату локализованную для Индии (например)
        ZoneId zoneId = ZoneId.of("Asia/Kolkata");
        ZonedDateTime zoneDateTime = ZonedDateTime.now(zoneId);
        System.out.println("\n2) Дата, локализованная для Индии: " + zoneDateTime);

        //3) вывести дату в формате 19-12-22, 19, 353, 11:47 <дата, день месяца, день в году, время>
        LocalDateTime date3 = LocalDateTime.now();
        System.out.println("\n3) Исходная дата: " + date3);
        int dateOfMonth3 = date3.getDayOfMonth();
        int month3 = date3.getMonthValue();
        int year3 = date3.getYear();
        int dayOfYear3 = date3.getDayOfYear();
        int hour3 = date3.getHour();
        int min3 = date3.getMinute();
        System.out.printf("Форматированный вывод даты = %d-%d-%d, %d, %d, %d:%d \n", dateOfMonth3, month3, year3, dateOfMonth3, dayOfYear3, hour3, min3); //шаблонизированный вывод в консоль

        //4) создать дату своего рождения, вывести на консоль в формате "10 Января 1985
        LocalDate dateMyBirthday4 = LocalDate.of(1976, 9, 7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM uuuu");
        String dateMyBirthdayFormatted4 = dateMyBirthday4.format(formatter);
        System.out.println("\n4) Мой день рождения: " + dateMyBirthdayFormatted4);

        //5) проверить дата "10 Января 1985" - это пятница, попробуйте получить день недели для любой другой даты?
        LocalDate day5 = LocalDate.of(1985, 1, 10);
        System.out.println("\n5) " + day5 + " --> is " + day5.getDayOfWeek());
        // проверяю день недели для моего дня рождения:
        System.out.println(dateMyBirthday4 + " --> is " + dateMyBirthday4.getDayOfWeek());

//        6) вычесть 10 лет из созданной даты, вывести на консоль
        LocalDate date6 = LocalDate.now();
        date6.minusYears(10);
        System.out.println("\n6) " + date6 + " минус 10 лет = " + date6.minusYears(10));

//        7) получить обьект Instant из "2022-12-19T06:55:30.00Z", вывести на консоль
        Instant instant7 = Instant.parse("2022-12-19T06:55:30.00Z");
        System.out.println("\n7) " +instant7);

//        8) получить ZonedDateTime из "Pacific/Midway", вывести на консоль
        ZoneId zone8 = ZoneId.of("Pacific/Midway");
        ZonedDateTime date8 = ZonedDateTime.now(zone8);
        System.out.println("\n8) ZonedDateTime из Pacific/Midway: --> " + date8);

//        9)* получить возраст человека на текущий момент, если известна его дата рождения.
        LocalDate dateBirthday9 = LocalDate.of(1976, 9, 7);
        LocalDate dateNow9 = LocalDate.now();
        Period period9 = Period.between(dateBirthday9, dateNow9);
        System.out.println("\n9) С момента рождения прошло: " +
                "\nЛет: " + period9.getYears() +
                " \nМесяцев: " + period9.getMonths() +
                " \nДней: " + period9.getDays());

//        10)* Вы просыпаетесь и смотрите на будильник. Вам на работу нужно на 9 часов. Узнайте, сколько времени
//        осталось еще до начала работы или если вы проспали, то на сколько.
        LocalDateTime timeWakeUp = LocalDateTime.now();
        LocalDateTime timeToWork10 = LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0));
        Duration duration10 = Duration.between(timeWakeUp, timeToWork10);
        if (duration10.toMinutes() > 0) {
            System.out.println("\n10) До рабочего времени осталось: " + duration10.toMinutes() + " минут");
        } else System.out.println("\n10) Ты проспал на " + duration10.toMinutes() + " минут");

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
