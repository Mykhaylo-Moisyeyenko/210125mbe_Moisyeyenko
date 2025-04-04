package de.telran.dz_multithread.synchronize_20250401.task3;

//3**. Вы открыли банк. У вас есть массив из 100 счетов клиентов. На каждом клиентском счете 1000 евро.
//Просчитайте общее количество денег на счетах клиентов.
//Представьте что за день, у вас в банке было проведено 10 000 операций.
//В каждой операции вы выбираете 2 случайных счета:
//с одного снимаете сумму например 10 евро и добавляете на другой счет эту же сумму.
//Просчитайте общее количество денег на счетах клиентов.
//У вас баланс денежных средств на счетах клиентов до начала операций должен быть равен количеству денег после окончание дня.
//Если это не так, то как Вы думаете почему?  Можно ли это исправить и как?

import java.util.ArrayList;
import java.util.List;

public class MainTask3 {

    public static void main(String[] args) throws InterruptedException {

        int sumOnAccounts = 0;

        List<Account> accounts = new ArrayList<>(); //создаю лист со счетами клиентов
        for (int i = 0; i < 100; i++) {//заполняю лист счетами с исходными 1000 евро на счету
            Account account = new Account(1000);
            accounts.add(i, account);
        }

        for (int i = 0; i < accounts.size(); i++) {//рассчитываю общее количество денег на счетах клиентов
            sumOnAccounts += accounts.get(i).getBalance();
        }
        System.out.println("Исходное количество денег на счетах клиентов: " + sumOnAccounts);

        TaskGetMoney taskGetMoney = new TaskGetMoney(accounts);
        TaskPayMoney taskPayMoney = new TaskPayMoney(accounts);

        Thread threadGetMoney = new Thread(taskGetMoney);
        Thread threadPayMoney = new Thread(taskPayMoney);

        threadGetMoney.start();
        threadPayMoney.start();

        threadGetMoney.join();
        threadPayMoney.join();

        sumOnAccounts = 0;//обнуляю счетчик перед проверкой общего баланса
        for (int i = 0; i < accounts.size(); i++) {//рассчитываю общее количество денег на счетах клиентов
            sumOnAccounts += accounts.get(i).getBalance();
        }
        System.out.println("Итоговая сумма денег на счетах клиентов после транзакций: " + sumOnAccounts);

        System.out.println("Состояние счетов после 10000 операций: \n" + accounts);
    }
}
