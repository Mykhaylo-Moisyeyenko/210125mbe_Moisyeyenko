package de.telran.dz_threadpool_20250411.task1;

//1. У вас есть задача проверять какой то сайт, с целью проверки опубликования
//на нем новой информации, но если мы будем слишком часто проверять этот сайт,
//то нас могут "забанить" за спам. Чтобы избежать этого, вы должны слать свои запросы
//не чаще чем один раз в минуту.
//Ваша задача должна работать паралельно основной функциональности и не занимать ресурсы
//главного потока.
//Подумайте, какой механизм Java вы могли бы использовать для автоматизации данной задачи.
//Как реализацию работы с сайтом, просто выведите сообщение о том, что соединение
//установлено и выведите текущее время.

import java.sql.Time;
import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainTask1 {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleWithFixedDelay(new TaskCheckEmail(),0, 5, TimeUnit.SECONDS);
// установил задержку в 5 секунд для наглядности
//шатдаун пула не выполняю, чтобы он продолжал работать в фоне
    }
}

class TaskCheckEmail implements Runnable{

    @Override
    public void run() {
        System.out.println("Соединение установлено в " + LocalTime.now());
    }
}
