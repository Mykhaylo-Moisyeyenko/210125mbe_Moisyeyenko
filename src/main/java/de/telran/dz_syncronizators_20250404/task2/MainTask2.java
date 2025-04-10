package de.telran.dz_syncronizators_20250404.task2;

//2*. Вы едете на экскурсии. Каждый человек, при входе в автобус, называет свою фамилию.
//Экскурсовод ставит у себя в блокноте птичку и если количество людей по списку совпадает
//автобус уезжает на экскурсию. Сымитируйте данный процесс работы.
//Какой синхронизатор с библиотеки concurrent Вы бы использовали для данного процесса?

import java.util.concurrent.CountDownLatch;

public class MainTask2 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(new Passenger(countDownLatch)).start();
        }
        Thread.sleep(500); //экскурсовод проверил, все ли расселись по местам
        System.out.println("Все 10 пассажиров уехали на экскурсию");
    }
}

class Passenger implements Runnable {
    CountDownLatch countDownLatch;

    public Passenger(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.countDown();
            System.out.println("Пассажир " + Thread.currentThread().getName()
                    + " пришел к автобусу и ждет");
            countDownLatch.await();
            System.out.println("Пассажир " + Thread.currentThread().getName()
                    + " едет в автобусе на экскурсию");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

