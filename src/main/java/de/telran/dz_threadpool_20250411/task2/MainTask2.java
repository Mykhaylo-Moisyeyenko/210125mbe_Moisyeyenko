package de.telran.dz_threadpool_20250411.task2;

//2*. В одном из предыдущий ДЗ у вас была задача:
//У вас в магазине распродажа. К вам набежало 10 000 клиентов и вы пытаетесь корректно всех обслужить с
//учетом того, что одновременно у вас внутри магазина может находиться не более 10 покупателей(согласно
//                                                                                                             карантинным нормам) и время обслуживания одного покупателя занимает 30 секунд.
//Сымитируйте данный процесс работы и подсчитайте за какой период времени вы сможете обслужить данный
//объем покупателей?
//Отдельный покупатель - отдельный поток.
//Можно было бы реализовать данную задачу не используя семафор?

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainTask2 {
    public static void main(String[] args) {
        ExecutorService shop = Executors.newFixedThreadPool(10);

        long startTime = System.currentTimeMillis();
        System.out.println(startTime);

        for (int i = 0; i < 10000; i++) {
            shop.execute(new Buyer(i + 1));
        }

        shop.shutdown();

        long endTime = System.currentTimeMillis();

        try {
            Thread.sleep(3000);//посчитали кассу
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nВсе покупатели обслужены");
        System.out.println("Затраченное время: " + (endTime - startTime) + " ms");

    }
}


class Buyer implements Runnable {
    int num;

    public Buyer(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        try {
            System.out.println("Покупателя " + num + " впустили в магазин");
            Thread.sleep(1);//покупатель совершает покупки 1 мс.
            System.out.println();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Покупатель " + num + " ушел");
    }
}