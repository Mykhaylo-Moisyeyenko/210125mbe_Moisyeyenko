package de.telran.dz_multithread_waitnotify_20250402.task2;

public class Unloader implements Runnable{

    private Ramp ramp;
    private int counterForUnloader; // счетчик, который используется в цикле выгрузки Unloadera

    public Unloader(Ramp ramp) {
        this.ramp = ramp;
    }

    @Override
    public void run() {
        counterForUnloader = ramp.getAmountBoxesToUnloud();
        for (int i = 0; i < counterForUnloader; i++) {
            try {
                ramp.putBoxes();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
