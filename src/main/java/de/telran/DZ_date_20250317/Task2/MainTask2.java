package de.telran.DZ_date_20250317.Task2;

import java.time.*;
import java.util.Date;

public class MainTask2 {

    //2*. Рейс из Лос-Анджелеса во Франкфурт отправляется в 15:05 по местному времени и длится 10 ч. 50 м.
//    Во сколько он прилетит? Написать метод, который мог бы совершать подобные вычисления (учтите что
//    часовые пояса разные)

    public static void main(String[] args) {

     timeArriving();

    }

    public static void timeArriving() {
        //Создаю дату и время вылета рейса из Лос-анджелеса:
        LocalDateTime timeDeparture = LocalDateTime.of(2025, 03, 18, 15, 05);
        System.out.println("Дата и время вылета из Лос-анджелеса: " + timeDeparture);

        // Ввожу переменную длительности рейса:
        LocalTime duration = LocalTime.of(10, 50);

        //Создаю временную зону для Лос-анджелеса:
        ZoneId zoneDeparture = ZoneId.of("America/Los_Angeles");

        //Создаю временную зону для Франкфурта-на-Майне:
        ZoneId zoneArriving = ZoneId.of("Europe/Berlin");

        //Выясняю разницу во времени между зонами городов:
        Duration difference = Duration.between(LocalTime.now(zoneDeparture), LocalTime.now(zoneArriving));
        System.out.println("Текущая разница временных поясов: " + difference.toHours() + " часов");

        //Выясняю время прилета во временной зоне Франкфурта-на-Майне:
        //1. Добавляю разницу временных поясов:
        LocalDateTime timeOfArriving = timeDeparture.plusHours(difference.toHours());

        //2. Добавляю продолжительность рейса:
        timeOfArriving = timeOfArriving.plusHours(duration.getHour());
        timeOfArriving = timeOfArriving.plusMinutes(duration.getMinute());

        //3. Вывожу итоговое время прибытия во Франкфурте:
        System.out.println("Время прибытия самолета во Франкфурт (по местному времени): " + timeOfArriving);

    }

}
