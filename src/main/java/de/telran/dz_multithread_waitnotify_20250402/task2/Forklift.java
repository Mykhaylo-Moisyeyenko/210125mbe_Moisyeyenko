package de.telran.dz_multithread_waitnotify_20250402.task2;

public class Forklift implements Runnable{

    private Ramp ramp;

    public Forklift(Ramp ramp){
        this.ramp = ramp;
    }

    @Override
    public void run() {
        while (ramp.getAmountBoxesToUnloud()!=0){
            try {
                ramp.takeBoxes();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
