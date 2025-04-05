package de.telran.dz_multithread_waitnotify_20250402.task1;

public class Table {
    private int amountDetails = 0;
    private int detailOnTable = 0;

    public Table(int amountDetails) {
        this.amountDetails = amountDetails;
    }

    public int getAmountDetails() {
        return amountDetails;
    }

    public synchronized void putDetails() throws InterruptedException {//метод выкладывания на стол
        while (detailOnTable > 0) {
            wait();
        }
        detailOnTable = 1;
        System.out.println("Робот положил деталь на стол");
        notify();
    }

    public synchronized void takeDetail() throws InterruptedException {
        while (detailOnTable == 0) {
            wait();
        }
        detailOnTable = 0;
        System.out.println("Деталь убрана со стола");
        notify();
    }
}

