package de.telran.dz_annotation_20250422.Task1;

//    Ниже - мой собственный класс из другого домашнего задания:

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

@MyAnnotationsTask1(reviewer = "Моисеенко М.В.", comment = "Почему так назван класс?")
public class ClassForAnnotations extends Thread {

    @MyAnnotationsTask1(reviewer = "Моисеенко М.В.", comment = "Здесь не должно быть final")
    private final AtomicBoolean isHit;

    @MyAnnotationsTask1(reviewer = "Моисеенко М.В.", comment = "Конструктор должен иметь два параметра")
    public ClassForAnnotations(AtomicBoolean isHit) {
        this.isHit = isHit;
    }

    @MyAnnotationsTask1(reviewer = "Моисеенко М.В.", comment = "Замечание про метод: тут должно быть другое число")
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
