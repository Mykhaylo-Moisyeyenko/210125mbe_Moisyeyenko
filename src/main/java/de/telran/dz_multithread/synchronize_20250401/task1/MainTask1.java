package de.telran.dz_multithread.synchronize_20250401.task1;

//1. На соревнованиях 5 спортсменов начинают одновременно стрелять в одну мишень.
//Если кто-нибудь в нее попадает(сделать Random-но), то мишень разрушается и другие в нее уже попасть не могут,
//но что-то пошло не так. Исправь программу, чтобы другие потоки "видели" изменения значения
//переменной isHit и больше его не меняли. Как только мишень разрушена кем то из стрелков,
//соревнования прекращаются. Подумайте, можно ли использовать класс AtomicBoolean?

import java.util.concurrent.atomic.AtomicBoolean;

public class MainTask1 {

    public static void main(String[] args) {

        AtomicBoolean isHit = new AtomicBoolean(false);

        Shooter shooter1 = new Shooter(isHit);
        Shooter shooter2 = new Shooter(isHit);
        Shooter shooter3 = new Shooter(isHit);
        Shooter shooter4 = new Shooter(isHit);
        Shooter shooter5 = new Shooter(isHit);

        shooter1.start();
        shooter2.start();
        shooter3.start();
        shooter4.start();
        shooter5.start();






    }
}
