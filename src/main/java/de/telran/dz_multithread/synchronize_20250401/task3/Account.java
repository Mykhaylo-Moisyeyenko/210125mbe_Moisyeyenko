package de.telran.dz_multithread.synchronize_20250401.task3;

public class Account {
    public int number;
    public int sum;

    public Account(int number, int sum) {
        this.number = number;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "\nAccount number = " + number + ", sum = " + sum;
    }



    }


