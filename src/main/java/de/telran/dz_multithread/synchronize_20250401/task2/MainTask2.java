package de.telran.dz_multithread.synchronize_20250401.task2;

//2*. Одна компания решила заработать миллион. Для этого они решили создать курсы, где за 1000
//можно обучиться чему-то очень интересному и полезному:
//они наняли преподавателей, которые получают 10% от суммы оплаты каждого студента.
//Напишите программу, которая даст возможность набирать студентов на курс до тех пор,
//пока компания не заработает миллион :) Подумайте, можно ли использовать класс AtomicInteger для накопления.
//(Нужно дописать условия, например что преподаватель обучает группу из 10 человек)

import de.telran.dz_multithread.synchronize_20250401.task1.Shooter;

import java.util.concurrent.atomic.AtomicInteger;

public class MainTask2 {

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger account = new AtomicInteger(0);
        AtomicInteger students = new AtomicInteger(0);

        IncomThread incomThread = new IncomThread(account, students);
        ExpencesThread expencesThread = new ExpencesThread(account, students);

        incomThread.start();
        expencesThread.start();

        incomThread.join();
        expencesThread.join();

        System.out.println("\nНеобходимое количество студентов, чтобы заработать миллион: " + students);
    }
}
