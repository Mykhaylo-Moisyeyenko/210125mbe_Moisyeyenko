package de.telran.DZ_multithread_base_20250326.Task3;

//3*.Посчитайте количество всех целых чисел в диапазоне от Integer.MIN_VALUE до Integer.MAX_VALUE,
//которые делятся на введенное пользователем число number без отстатка.
//Просчитайте время, которое необходимо для вычисления данного результата в одном потоке.
//Просчитайте время, которое необходимо пользователю для выполнения этих задачи паралельно,
//количество создаваемых потоков countThreads пользователь тоже должен ввести вручную .

import de.telran.DZ_multithread_base_20250326.Task1.MainTask1;

import java.util.Scanner;

public class MainTask3 extends Thread {

    long start;
    long end;
    private static int divider;

    public MainTask3(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите делитель number: ");
        divider = scanner.nextInt();
        System.out.print("Введите количество потоков: ");
        int numberThreads = scanner.nextInt();

        //просчет времени на 1 поток:
        long startTime = System.currentTimeMillis();
        int counter = 0;
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            if (i % divider == 0) {
                counter++;
            }
        }
        System.out.println("Результат деления в один поток: " + counter);
        System.out.println("Время работы в один поток: " + (System.currentTimeMillis() - startTime));

       //вычисляю диапазоны чисел для передачи в потоки:
        long a = Integer.MIN_VALUE;
        long b = Integer.MAX_VALUE;
        long range = (b - a) / numberThreads;//выясняю размер диапазонов для потоков

        MainTask3[] massThreads = new MainTask3[numberThreads];//массив для потоков

        long startTimeMultiThread = System.currentTimeMillis(); // Замеряем время перед созданием потоков

        for (int i = 0; i < numberThreads; i++) {//в цикле выясняю диапазоны, создаю потоки и запускаю их
            long start = Integer.MIN_VALUE + i * range;
            System.out.println("стартовое число диапазона для потока: " + start);
            long end;
            if (i == numberThreads - 1) {
                end = Integer.MAX_VALUE;
            } else end = start + range;
            System.out.println("последнее число диапазона для потока: " + end);

            MainTask3 thread = new MainTask3(start, end);
            massThreads[i] = thread; //складываю потоки в массив, чтобы закрывать их после запуска всех потоков
            thread.start();
        }

        for (int i = 0; i < massThreads.length; i++) {
            massThreads[i].join();
        }
        // Выводим общий результат
        System.out.println("Время работы в " + numberThreads + " потоков: " + (System.currentTimeMillis() - startTimeMultiThread));
    }

    @Override
    public void run() {
        long counter = 0;
        for (long i = start; i < end; i++) {
            if (i % divider == 0) {
                counter++;
            }
        }
        System.out.println("Результат деления для разделенных потоков: " + counter);
    }
}
