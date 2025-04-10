package de.telran.dz_syncronizators_20250404.task1;

//1. У вас в магазине распродажа. К вам набежало 10 000 клиентов и вы пытаетесь
//корректно всех обслужить с учетом того, что одновременно у вас внутри магазина
//может находиться не более 10 покупателей(согласно карантинным нормам)
//и время обслуживания одного покупателя занимает 30 секунд(откорректируйте под себя).
//Сымитируйте данный процесс
//работы и подсчитайте за какой период времени вы сможете обслужить данный объем покупателей?
//Отдельный покупатель - отдельный поток.
//Какой синхронизатор с библиотеки concurrent Вы бы использовали?

import java.util.concurrent.Semaphore;

public class MainTask1 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(10);
        Thread lastThread = null;
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);

        for (int i = 0; i < 10000; i++) {
            Thread newThread = new Thread(new Buyer(semaphore));
            newThread.start();
            lastThread = newThread;
        }
        lastThread.join();
        Thread.sleep(500);//посчитали кассу
        System.out.println("\nВсе покупатели обслужены");
        System.out.println("Затраченное время: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}


class Buyer implements Runnable {
    Semaphore semaphore;

    public Buyer(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println("Покупатель " + Thread.currentThread().getName()
                    + " подошел к двери и спросил можно ли войти");
            semaphore.acquire(); // -1
            System.out.println("Покупателя " + Thread.currentThread().getName()
                    + " впустили в магазин");
            Thread.sleep(1);
            System.out.println();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Покупатель " + Thread.currentThread().getName() + " ушел");
        semaphore.release();

    }
}
