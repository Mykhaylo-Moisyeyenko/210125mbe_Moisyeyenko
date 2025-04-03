package de.telran.dz_multithread.synchronize_20250401.task3;

//3**. Вы открыли банк. У вас есть массив из 100 счетов клиентов. На каждом клиентском счете 1000 евро.
//Просчитайте общее количество денег на счетах клиентов.
//Представьте что за день, у вас в банке было проведено 10 000 операций.
//В каждой операции вы выбираете 2 случайных счета:
//с одного снимаете сумму например 10 евро и добавляете на другой счет эту же сумму.
//Просчитайте общее количество денег на счетах клиентов.
//У вас баланс денежных средств на счетах клиентов до начала операций должен быть равен количеству денег после окончание дня.
//Если это не так, то как Вы думаете почему?  Можно ли это исправить и как?

import de.telran.lesson16_sorting_objects.dz_sorting.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainTask3 {

    public static void main(String[] args) {

        int sumOnAccounts = 0;
        int accGetMoney;
        int accPayMoney;

        List<Account> accounts = new ArrayList<>(); //лист со счетами клиентов

        for (int i = 0; i < 100; i++) {//заполняю лист счетами с исходными 1000 евро на счету
            Account account = new Account(i, 1000);
            accounts.add(i, account);
        }

        for (int i = 0; i < accounts.size(); i++) {//рассчитываю общее количество денег на счетах клиентов
            sumOnAccounts += accounts.get(i).sum;
        }
        System.out.println("Общее количество денег на счетах клиентов: " + sumOnAccounts);

        Random random = new Random();//рандомайзер для пары случайных счетов (а вернее - их индекс в Листе)

        for (int i = 0; i < 10000; i++) {//инициирую 10000 операций по списанию-оплате 10 евро
            accGetMoney = random.nextInt(100);
            accPayMoney = random.nextInt(100);
            if (accounts.get(accGetMoney).sum>=10){//проверяю наличие на счету более чем 10 евро
                accounts.get(accGetMoney).sum -= 10;//списываю 10 евро
                accounts.get(accPayMoney).sum += 10;//зачисляю 10 евро
            }
        }
        System.out.println("Общее количество денег на счетах клиентов: " + sumOnAccounts);
        System.out.println("Состояние счетов после 10000 операций: \n" + accounts);
    }
}
