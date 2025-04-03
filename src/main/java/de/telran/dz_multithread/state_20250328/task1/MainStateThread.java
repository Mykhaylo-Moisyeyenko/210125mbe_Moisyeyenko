package de.telran.dz_multithread.state_20250328.task1;

//1. Запустите в 3 потока просчет количества всех простых чисел в интервале от 2 до 1_000_000.
//с визуализацией просчета.
//Используя метод interrupt():
//Через 5 секунд завершите принудительно выполнение 1-го потока командой из главного.
//        Через 10 секунд завершите и 2-й поток.
//Через 15 секунд - 3-й поток.
//Время подкорректируйте под скорость своего компьютера.

public class MainStateThread {

    public static void main(String[] args) throws InterruptedException {

        Task task1 = new Task(2, 333333);
        Task task2 = new Task(333334, 666666);
        Task task3 = new Task(666667, 1000000);

        task1.start();
        task2.start();
        task3.start();

        Thread.sleep(100);
        task1.interrupt();

        Thread.sleep(100);
        task2.interrupt();

        Thread.sleep(100);
        task3.interrupt();

        task1.join();
        task2.join();
        task3.join();

        System.out.println("Все потоки завершили работу");


    }


}
