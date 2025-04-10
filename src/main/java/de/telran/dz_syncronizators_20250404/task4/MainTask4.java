package de.telran.dz_syncronizators_20250404.task4;

//4**. Кассир в магазине. К нему подходят клиенты с товарам отдают ему деньги и получают сдачу.
//По окончанию работы кассир подсчитывает сумму в кассе и сдает выручку.
//Кассир и каждый покупатель - это отдельные потоки. Сымитируйте данный процесс работы.
//Сумма оплаты и сумма сдачи может быть сгенерирована случайным образом,
//чтобы сдача была всегда меньше чем оплата.
//Какой синхронизатор с библиотеки concurrent Вы бы использовали для данного процесса?

import java.util.Random;
import java.util.concurrent.Exchanger;

public class MainTask4 {
    public static void main(String[] args) throws InterruptedException {

        Exchanger<Integer> exchanger = new Exchanger<>();
        Integer cash = 0;
        Integer sumOnTable = 0;

        Cashier cashier = new Cashier(exchanger, cash, sumOnTable); //создаю 1 кассира

        for (int i = 0; i < 20; i++) {// обслужим 20 покупателей
            Buyer buyer = new Buyer(exchanger, sumOnTable);
            new Thread(buyer).start();//создаю поток покупателя
            Thread.sleep(100);
            cashier.sumOnTable = buyer.sumOnTable;//кассир видит деньги на столе
            cashier.run();//кассир выплачивает сдачу
        }
        System.out.println("Все покупатели обслужены, в кассе: " + cashier.cash + " $");
    }
}

class Buyer implements Runnable {
    Exchanger<Integer> exchanger;
    Integer sumOnTable;

    public Buyer(Exchanger<Integer> exchanger, Integer sumOnTable) {
        this.exchanger = exchanger;
        this.sumOnTable = sumOnTable;
    }

    @Override
    public void run() {
        Random random = new Random();//рандомайзер для определения сумм.
        int sumToPay = random.nextInt(1,100);//генерирую сумму для оплаты покупателем

        sumOnTable = sumToPay;
        System.out.println("Покупатель " + Thread.currentThread().getName() + " положил на стол перед кассиром " + sumOnTable + " $");
        try {
            exchanger.exchange(sumToPay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Cashier implements Runnable {
    Exchanger<Integer> exchanger;
    Integer cash;
    Integer sumOnTable;

    public Cashier(Exchanger<Integer> exchanger, Integer cash, Integer sumOnTable) {
        this.exchanger = exchanger;
        this.cash = cash;
        this.sumOnTable = sumOnTable;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();//рандомайзер для определения сумм.
            int sumToPayBack = random.nextInt(sumOnTable);//генерирую сумму для выплаты сдачи - чтобы было меньше, чем оплатил покупатель
            Integer temp = exchanger.exchange(sumToPayBack);
            cash += temp;//кладу деньги в кассу
            System.out.println("Кассир выдал сдачу " + sumToPayBack + " $");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
