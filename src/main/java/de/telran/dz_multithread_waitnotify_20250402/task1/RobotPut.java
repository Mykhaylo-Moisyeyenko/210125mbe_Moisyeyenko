package de.telran.dz_multithread_waitnotify_20250402.task1;

public class RobotPut implements Runnable {

    private Table table;

    public RobotPut(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        for (int i = 0; i < table.getAmountDetails(); i++) {
            try {
                table.putDetails();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
