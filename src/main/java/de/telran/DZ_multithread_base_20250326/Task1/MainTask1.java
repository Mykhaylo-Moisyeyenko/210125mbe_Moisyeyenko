package de.telran.DZ_multithread_base_20250326.Task1;

//1. Пользователь с клавиатуры вводит цифру. Вы создаете динамически нужное количество
//потоков равное введенной цифре, нумеруете их и запускаете на выполнение.
//Каждый поток должен выводить свой номер на экран 100 раз с интервалом 100 милисекунд
//перед каждым выводом.
//Сделайте так, чтобы главный поток выполнения программы не завершился
//до окончания работы всех дочерних потоков.

import java.util.Scanner;

public class MainTask1 extends Thread {

    int numThread;

    public MainTask1(int numThread) {
        this.numThread = numThread;
    }

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество потоков: ");
        int numberThreads = scanner.nextInt();

        MainTask1[] massThreads = new MainTask1[numberThreads];
        for (int i = 1; i <= numberThreads; i++) {
            MainTask1 thread = new MainTask1(i);
            massThreads[i-1] = thread;
            thread.start();
        }

        for (int i = 0; i < massThreads.length; i++) {
            massThreads[i].join();
        }
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println("Я поток номер " + this.numThread);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
