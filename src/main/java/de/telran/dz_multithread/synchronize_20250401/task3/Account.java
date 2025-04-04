package de.telran.dz_multithread.synchronize_20250401.task3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private int balance;
    private final Lock lock;

    public Account(int balance) {
        this.balance = balance;
        this.lock = new ReentrantLock(); // Создаю новый Lock для каждого счета
    }

    public int getBalance() {
        lock.lock();//замок обеспечивает монопольный доступ к балансу счета
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }

    public Lock getLock() {
        return lock;
    }

    public void getMoney() {
        lock.lock();
        try{
            if (this.getBalance()>=10){//проверяю чтобы на счету было не менее 10 евро
                this.balance-=10;
            }
        }
        finally {
            lock.unlock();
        }
    }

    public void payMoney() {
        lock.lock();
        try {
            this.getBalance();//получаю баланс счета
            this.balance += 10;//увеличиваю его
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "\nAccount balance: " + this.getBalance();
    }

}


