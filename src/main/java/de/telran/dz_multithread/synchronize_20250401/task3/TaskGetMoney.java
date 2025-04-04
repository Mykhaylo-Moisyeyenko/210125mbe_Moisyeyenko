package de.telran.dz_multithread.synchronize_20250401.task3;

import java.util.List;
import java.util.Random;

public class TaskGetMoney implements Runnable {

    private final List<Account> accounts;

    public TaskGetMoney(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public void run() {
        Random random = new Random();//рандомайзер для выбора счета (а вернее - их индекса в Листе)
        for (int i = 0; i < 1000000; i++) {//инициирую 1000000 операций по списанию 10 евро
            int accGetMoney = random.nextInt(100);//получаю индекс рандомного исходного счета в диапазоне 0-99
            this.accounts.get(accGetMoney).getLock().lock();//блокирую конкретный банковский счет
            try {
                this.accounts.get(accGetMoney).getMoney();
            } finally {
                this.accounts.get(accGetMoney).getLock().unlock();//блокирую конкретный банковский счет
            }
        }
    }
}
