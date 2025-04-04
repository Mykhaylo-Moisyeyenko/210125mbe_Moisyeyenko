package de.telran.dz_multithread.synchronize_20250401.task3;

import java.util.List;
import java.util.Random;

public class TaskPayMoney implements Runnable{

    private final List<Account> accounts;

    public TaskPayMoney(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public void run() {
        Random random = new Random();//рандомайзер для выбора счета (а вернее - их индекса в Листе)
        for (int i = 0; i < 1000000; i++) {//инициирую 1000000 операций по оплате 10 евро
            int accPayMoney = random.nextInt(100);//получаю индекс рандомного целевого счета в диапазоне 0-99
            this.accounts.get(accPayMoney).getLock().lock();//блокирую конкретный банковский счет
            try {
                this.accounts.get(accPayMoney).payMoney();
            } finally {
                this.accounts.get(accPayMoney).getLock().unlock();//блокирую конкретный банковский счет
            }
        }
    }
}
