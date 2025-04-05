package de.telran.dz_multithread_waitnotify_20250402.task1;

//1. У вас есть стол, на который один робоманипулятор ложит деталь, а второй забирает эту деталь.
//Когда Робот1 положит деталь на стол, он должет обязательно ждать, пока Робот2 заберет эту деталь
//и только тогда ложить следующую. Постройте программу, которая автоматизирует эту работу.
//        Количество деталей, которые должны обработать манипуляторы, пользователь задает с клавиатуры.
//        (wait - notify)

import java.util.Scanner;

public class MainTask1 {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество деталей для программы: ");
        int amountDetails = scanner.nextInt();

        Table table = new Table(amountDetails);
        RobotPut robotPut = new RobotPut(table);
        RobotTake robotTake = new RobotTake(table);
        Thread threadPut = new Thread(robotPut);
        Thread threadTake = new Thread(robotTake);
        threadPut.start();
        threadTake.start();
        threadPut.join();
        threadTake.join();
    }
}
