package de.telran.dz_multithread.synchronize_20250401.task2;

import java.util.concurrent.atomic.AtomicInteger;

public class IncomThread extends Thread {

    private final AtomicInteger account;
    private final AtomicInteger students;

    public IncomThread(AtomicInteger account, AtomicInteger students) {
        this.account = account;
        this.students = students;
    }

    @Override
    public void run() {
        while (account.get() < 1000000) {
            synchronized (account) {
                students.getAndAdd(10);
                System.out.println("Студентов: " + students.get());
                account.getAndAdd(10000);
                System.out.println("Состояние банковского счета после прихода новых студентов: " + account.get());

                try {
                    account.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
