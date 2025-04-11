package de.telran.dz_synchronized_20250408.task2;

//2*. Вы пишете книгу и вы автор. Есть 2 человека, которые выступают у вас соавторами.
//На этапе написания книги, они пишут разные главы, помогая таким образом вам полностью ее закончить.
//После того как вы и все соавторы закончили свою работу, вы отправляете книгу на рецензирование.
//В группу рецензентов входит 3 человека, каждый из которых является специалистом в своей области
//и проверяет Вашу книгу на правильность отражения фактов в вашем произведении.
//После того. как все рецензии получены, Вы отправляете книгу в издательский дом.
//В редакции главный редактор и руководитель издательства читают ваше творение и утверждают
//его в печать.
//Вы относите утвержденные рукописи печатникам, они печатают книгу, переплетчики делают ей переплет
//а служба доставки развозят книги по магазинам.
//        Поздравляю Вас, вы полностью прошли все фазы становления известного писателя, т.к. Ваша книга
//стала бестселлером! )
//        Создайте приложение, которое сымитирует работу процесса создания книги, с учетом что каждый человек,
//который встречается в описаной схеме будет представлен отдельным потоком.
//Какой синхронизатор с библиотеки concurrent мог бы быть Вам полезен при выполнении данной задачи?

import java.util.concurrent.Phaser;

public class MainTask2 {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);//включаю в фазер главный поток

        new Thread(new MyBook(phaser, "Соавтор 1")).start(); //поток соавтора-1
        new Thread(new MyBook(phaser, "Соавтор 2")).start(); //поток соавтора-1

        System.out.println("Я написал свои главы и жду главы от соавторов");
        phaser.arriveAndAwaitAdvance();//главный поток написал свои главы

        new Thread(new MyBook(phaser, "Рецензент 1")).start(); //поток рецензента-1
        new Thread(new MyBook(phaser, "Рецензент 2")).start(); //поток рецензента-2
        new Thread(new MyBook(phaser, "Рецензент 3")).start(); //поток рецензента-3

        System.out.println("Я отдал книгу рецензентам");
        phaser.arriveAndAwaitAdvance();//главный поток написал свои главы

        new Thread(new MyBook(phaser, "Редактор")).start(); //поток редактора
        new Thread(new MyBook(phaser, "Руководитель издательства")).start(); //поток руководителя издательства
        System.out.println("Я отдал книгу в издательство");
        phaser.arriveAndAwaitAdvance();

        new Thread(new MyBook(phaser, "Печатники")).start(); //соответствующий поток
        System.out.println("Издательство передало книгу печатникам");
        phaser.arriveAndAwaitAdvance();

        new Thread(new MyBook(phaser, "Переплетчики")).start(); //соответствующий поток
        System.out.println("Издательство передало книгу переплетчикам");
        phaser.arriveAndAwaitAdvance();

        new Thread(new MyBook(phaser, "Служба доставки")).start(); //соответствующий поток
        System.out.println("Книгу передали службе доставки");
        phaser.arriveAndAwaitAdvance();

        System.out.println("Ура! Моя книга опубликована!!!");
        phaser.arriveAndDeregister();
    }
}

class MyBook implements Runnable{

    Phaser phaser;
    String name;

    public MyBook(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();//регистрирую поток при создании
    }

    @Override
    public void run() {
        System.out.println(name + " начал свою работу");
        try {
            Thread.sleep(500);// имитирую работу потока в фазе
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " закончил свою работу");
        phaser.arriveAndDeregister();
    }
}



