package de.telran.dz_multithread.synchronize_20250401.task1;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Shooter extends Thread {

    private final AtomicBoolean isHit;

    public Shooter(AtomicBoolean isHit) {
        this.isHit = isHit;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {// у каждого стрелка по 5 выстрелов
            if (isHit.get()) {//проверяю - была ли уже поражена мишень
                System.out.println(Thread.currentThread().getName() + " - прекратил стрелять, т.к. цель была поражена");
                return;
            }
            if (random.nextBoolean() && isHit.compareAndSet(false, true)) {
                System.out.println("Выстрел потока " + Thread.currentThread().getName() + ". Цель была поражена -> " + isHit);
                return;
            }
            try {
                Thread.sleep(2000);// имитирую паузу между выстрелами у стрелка
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
