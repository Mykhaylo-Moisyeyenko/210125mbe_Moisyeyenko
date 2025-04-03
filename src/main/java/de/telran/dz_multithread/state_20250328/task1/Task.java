package de.telran.dz_multithread.state_20250328.task1;

public class Task extends Thread {

    int start;
    int end;

    public Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().getName() + " завершен");
                return;
            };
            for (int j = start; j <= end; j++) {
                if (i % j == 0) {
                    if (i / j == 1) {
                        System.out.println(Thread.currentThread().getName() + " Простое число: " + i);
                        count++;
                    }
                    break;
                }
            }
        }
        System.out.println("Количество простых чисел: " + count);
    }
}
