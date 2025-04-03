package de.telran.dz_multithread.synchronize_20250401.task2;

import java.util.concurrent.atomic.AtomicInteger;

public class ExpencesThread extends Thread {

    private final AtomicInteger account;
    private final AtomicInteger students;
    private int counter = 0;
    private int sumOfPaymentsToTeachers = 0;

    public ExpencesThread(AtomicInteger account, AtomicInteger students) {
        this.account = account;
        this.students = students;
    }

    @Override
    public void run() {
        while (account.get() < 1000000) {
            synchronized (account) {
                if (students.get() > counter) {
                    int newStudents = (students.get() - counter);//выясняю - сколько новых студентов появилось
                    double payment = newStudents * 1000 * 0.1;  // зп преподавателям за новых студентов
                    account.getAndAdd((int) -payment); //отнимаю со счета зарплату преподавателей
                    sumOfPaymentsToTeachers += (int) payment;//подсчитываю общую сумму зп преподавателей
                    counter = students.get();
                    System.out.println("Выплачено преподавателям: " + payment);
                    System.out.println("Состояние банковского счета после выплаты зп преподавателям: " + account);
                }
                account.notify();
            }
        }
        System.out.println("Итого выплачено преподавателям: " + sumOfPaymentsToTeachers);
    }
}
