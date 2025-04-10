package de.telran.dz_syncronizators_20250404.task3;

//3*. Для подъема на смотровую площадку работает лифт, в который одновременно
//может сесть не более 5 человек.
//Создайте программу-симулятор работы лифта, при разном количестве людей в группе
//(можно вводить с клавиатуры).
//Каждый человек - отдельный поток.

import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MainTask3 {
    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество людей в группе: ");
        int numberPeople = scanner.nextInt();

        for (int i = 0; i < numberPeople; i++) {
            new Thread(new Lift(cyclicBarrier)).start();
            Thread.sleep(1000);//моделирую ожидание следующего человека
        }
    }
}

class Lift implements Runnable{
    CyclicBarrier cyclicBarrier;

    public Lift(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println("Человек " + Thread.currentThread().getName() + " подошел к лифту и ожидает своей очереди");
            cyclicBarrier.await();
            System.out.println("Человек " + Thread.currentThread().getName() + " вошел в лифт и лифт поехал");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
