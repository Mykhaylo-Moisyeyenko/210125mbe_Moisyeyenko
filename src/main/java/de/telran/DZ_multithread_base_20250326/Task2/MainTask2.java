package de.telran.DZ_multithread_base_20250326.Task2;

//2. Запустите в 3 потока просчет суммы всех чисел, который без остатка деляться на 17
//в интервале от 0 до 10 млн. Показывайте на экран, как будет накапливаться сумма по каждому потоку.
//После запуска просчета, главный поток остановите на 1 секунду и завершите его.
//Все дочерние потоки должны автоматически закрыться. (Daemons)

import de.telran.DZ_multithread_base_20250326.Task1.MainTask1;

public class MainTask2 extends Thread {

    private int start;
    private int end;

    public MainTask2(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) throws InterruptedException {

        MainTask2 thread1 = new MainTask2(0, 3333333);
        MainTask2 thread2 = new MainTask2(3333334,6666666);
        MainTask2 thread3 = new MainTask2(6666667, 10000000);
        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread3.setDaemon(true);
        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(50); //я уменьшил время, чтобы увидеть в консоли начало работы потоков
    }

    @Override
    public void run(){
        long sum = 0;
        for (int i = start; i < end; i++) {
            if (i%17==0){
                sum+=i;
                System.out.println("Я процесс " + currentThread().getName() + " и сумма чисел: " + sum);
            }
        }
    }
}
