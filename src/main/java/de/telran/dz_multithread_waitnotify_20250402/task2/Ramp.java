package de.telran.dz_multithread_waitnotify_20250402.task2;

public class Ramp {

    private int amountBoxesToUnloud;
    private int boxesOnRamp = 0;

    public int getAmountBoxesToUnloud() {
        return amountBoxesToUnloud;
    }

    public int getBoxesOnRamp() {
        return boxesOnRamp;
    }

    public Ramp(int amountBoxesToUnloud) {
        this.amountBoxesToUnloud = amountBoxesToUnloud;
    }

    public synchronized void putBoxes() throws InterruptedException {//метод выгрузки на рампу
        while (boxesOnRamp > 1) {
            wait();
        }
        boxesOnRamp += 1;
        System.out.println("Выгрузчик выгрузил 1 ящик на рампу");
        notifyAll();
        Thread.sleep(102);//имитирую работу выгрузчика
    }

    public synchronized void takeBoxes() throws InterruptedException {//метод отправки с рампы в склад
        while (boxesOnRamp == 0) {
            if (amountBoxesToUnloud == 0) {
                notifyAll();
                return;
            }
            wait();
        }
        boxesOnRamp -= 1;
        amountBoxesToUnloud -= 1;
        System.out.println("Вилочный погрузчик " + Thread.currentThread().getName() + " забрал 1 деталь");
        notifyAll();
        Thread.sleep(100);//имитирую работу погрузчика
    }
}

