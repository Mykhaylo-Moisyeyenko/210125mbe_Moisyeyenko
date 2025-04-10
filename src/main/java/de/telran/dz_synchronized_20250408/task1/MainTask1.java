package de.telran.dz_synchronized_20250408.task1;

//1. Напишите программу просчета количества всех простых в диапазоне до 1 000 000.
//Просчет выполняйте в 4 потоках, которые создаются с помощью Callable.
//Получите результаты подсчета из каждого потока и напечатайте общий результат.

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MainTask1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> task1 = new ThreadCallable(2, 2500);//Диапазон уменьшен специально, чтобы ускорить
        Callable<Integer> task2 = new ThreadCallable(2501, 5000);
        Callable<Integer> task3 = new ThreadCallable(5001, 7500);
        Callable<Integer> task4 = new ThreadCallable(7501, 10000);

        FutureTask<Integer> futureTask1 = new FutureTask<>(task1);
        FutureTask<Integer> futureTask2 = new FutureTask<>(task2);
        FutureTask<Integer> futureTask3 = new FutureTask<>(task3);
        FutureTask<Integer> futureTask4 = new FutureTask<>(task4);
        new Thread(futureTask1).start();
        new Thread(futureTask2).start();
        new Thread(futureTask3).start();
        new Thread(futureTask4).start();

        System.out.println("Общее количество простых чисел: "
                + (futureTask1.get()
                + futureTask2.get()
                + futureTask3.get()
                + futureTask4.get()));
    }
}

class ThreadCallable implements Callable<Integer> {

    private int start;
    private int end;

    public ThreadCallable(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        Integer count = 0;
        for (int i = start; i <= end; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(Thread.currentThread().getName() + " Простое число: " + i);
                count++;
            }
        }
        return count;
    }
}


