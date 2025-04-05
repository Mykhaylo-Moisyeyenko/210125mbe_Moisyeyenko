package de.telran.dz_multithread_waitnotify_20250402.task2;

//2*. На склад приезжает машина, в которой загружено N ящиков (пользователь вводит с клавиатуры).
//Автоматизированный разгрузчик вытягивает с машины ящик и ложит на рампу с определенным интервалом времени,
//на которой может одновременно разместиться например 2 ящика.
//В это время подъезжает автоматизированный погрузчик и везет его на место хранения. Он за раз может взять всего
//1 ящик. Каждый участник процесса представлен в виде отдельного потока Java.
//        Создайте программу, которая синхронизирует работу в данном процессе разгрузки автомобиля, с условием того,
//что Разгрузчик может быть только один, а Погрузчиков может быть 2 и более (на ваше усмотрение).


import de.telran.dz_multithread_waitnotify_20250402.task1.RobotPut;
import de.telran.dz_multithread_waitnotify_20250402.task1.RobotTake;
import de.telran.dz_multithread_waitnotify_20250402.task1.Table;

import java.util.Scanner;

public class MainTask2 {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество ящиков для выгрузки: ");
        int amountBoxesToUnloud = scanner.nextInt();

        Ramp ramp = new Ramp(amountBoxesToUnloud);
        Unloader unloader = new Unloader(ramp);
        Forklift forklift1 = new Forklift(ramp);
        Forklift forklift2 = new Forklift(ramp);

        Thread threadUnloader = new Thread(unloader);
        Thread threadForklift1 = new Thread(forklift1);
        Thread threadForklift2 = new Thread(forklift2);

        threadUnloader.start();
        threadForklift1.start();
        threadForklift2.start();

        threadUnloader.join();
        threadForklift1.join();
        threadForklift2.join();
    }
}
