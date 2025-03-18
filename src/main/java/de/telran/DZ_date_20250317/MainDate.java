package de.telran.DZ_date_20250317;

import java.util.Date;

public class MainDate {
    public static void main(String[] args) {
        Date date1 = new Date();
        System.out.println("Текущая дата = "+date1);
        System.out.println("Текущая дата (long) = "+date1.getTime());

        Date date2 = new Date(3665467688799L);
        System.out.println("Наша дата = "+date2);

//Не рекомендуется к использованию
        Date date3 = new Date(125, 1, 19); // месяц с 0, год - не понятный алгоритм
        System.out.println("Введенная дата = "+date3);

// Сравнение
        System.out.println("Сравнение милисекунд = "+(date2.getTime() >= date1.getTime()));

        boolean fl = date1.after(date2); // date1 после date2
        System.out.println("after -> "+fl);

        fl = date1.before(date2); // date1 перед date2
        System.out.println("before -> "+fl);

// Присвоение
        date3 = new Date(); // разные объекты в Heap
        date3.setTime(date1.getTime());

        date2.setTime(3665467688799L);  // милисекунды
        date2.setHours(12); //не рекомендуеться @Deprecated

        int compare = date1.compareTo(date2); // сравнения 2х дат
        System.out.println("compareTo ->"+compare); // компаринг
    }

}
