package de.telran.DZ_generic_20250311;

public class Dancer implements Artist<Dancer> {

    @Override
    public void perform(Dancer dancer) {
        System.out.println("I am Dancer and i'm performing a Dance");
    }
}
