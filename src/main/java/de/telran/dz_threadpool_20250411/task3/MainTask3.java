package de.telran.dz_threadpool_20250411.task3;

//3**
//Вы владелец кафе. Вы предлагаете клиентам блюда собственного приготовления, снеки и алкоголь.
//Сгенерируйте выторг данного кафе (количество на Ваше усмотрение) в формате:
//-наименование
//-тип (кухня, снек, алкоголь)
//-сумма (10-100)
//
//По окончании отчетного периода, вам нужно подсчитать налоги и доход:
//        1) Со всей суммы выторга нужно забрать НДС - 15%.
//        2) С алкоголя, нужно забрать 2% акцизного сбора.
//        3) Снеки облагаются доп.налогом 1%.
//        4) С продуктов кухни нужно снять 10%, как доп.выплату поварам.
//        5) Зарплата сотрудникам рассчитывается как 20% от общей суммы.
//6) Инвесторам нужно выплатить 10 %.
//Вычислите сумму дохода и % составляет доход в от суммы общей выручки?

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MainTask3 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int sumKitchen = 0;
        int sumSnacks=0;
        int sumAlcohol=0;

        //кафе может обслужить не более 10 клиентов сразу:
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //генерирую 100 клиентов и складываю их в ArrayList
        List<Callable<int[]>> listOfClients= new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listOfClients.add(i, new Client());
        }

        // Создаю список, куда будут складываться массивы с выторгом после каждого клиента
        // и передаю список моих клиентов в метод invokeAll
        List <Future<int[]>> cashFromClients = executorService.invokeAll(listOfClients);

        //Достаю из списка результаты по каждому клиенту и плюсую к общему итогу по категориям:
        for (Future<int[]> clientsResults: cashFromClients){
            int [] sum = clientsResults.get();
            sumKitchen += sum[0];
            sumSnacks += sum[1];
            sumAlcohol += sum[2];
        }
        executorService.shutdown();// закрываем executor

        System.out.println("Итоговый выторг по кухне: " + sumKitchen);
        System.out.println("Итоговый выторг по снэкам: " + sumSnacks);
        System.out.println("Итоговый выторг по алкоголю: " + sumAlcohol);

        int fullCash = sumKitchen+sumSnacks+sumAlcohol;
        System.out.println("Общая сумма выторга кафе: " + fullCash);

//        1) Со всей суммы выторга нужно забрать НДС - 15%.
        double a = fullCash*0.15;
        System.out.println("НДС к выплате: " + a);

//        2) С алкоголя, нужно забрать 2% акцизного сбора.
        double b = sumAlcohol*0.02;
        System.out.println("Акциз к выплате: " + b);

//        3) Снеки облагаются доп.налогом 1%.
        double c = sumSnacks*0.01;
        System.out.println("Доп.налог со снэков к выплате: " + c);

//        4) С продуктов кухни нужно снять 10%, как доп.выплату поварам.
        double d = sumKitchen*0.10;
        System.out.println("Поварам к выплате: " + d);

//        5) Зарплата сотрудникам рассчитывается как 20% от общей суммы.
        double e = fullCash*0.2;
        System.out.println("ЗП сотрудникам к выплате: " + e);

//6) Инвесторам нужно выплатить 10 %.
        double f = fullCash*0.1;
        System.out.println("Инвесторам к выплате: " + f);

//Вычислите сумму дохода и % составляет доход в от суммы общей выручки?
        System.out.println("Чистая прибыль: " + (fullCash-a-b-c-d-e-f));
        System.out.println("Процент чистой прибыли от суммы общей выручки: "
                + (fullCash-a-b-c-d-e-f)*100/fullCash);
    }
}

class Client implements Callable<int[]>{
// класс клиентов, у которых случайно генерируется чек в диапазоне 10-90$
// по кухне, снэкам и алкоголю
    @Override
    public int[] call() throws Exception {
        int kitchen = (int) (Math.random()*91)+10;
        int snacks = (int) (Math.random()*91)+10;
        int alcohol = (int) (Math.random()*91)+10;
        return new int[]{kitchen, snacks, alcohol};
    }
}

