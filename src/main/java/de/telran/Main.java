package de.telran;

import de.telran.DZ_generic_20250311.Dancer;
import de.telran.DZ_generic_20250311.DoubleCalculator;
import de.telran.DZ_generic_20250311.FloatCalculator;
import de.telran.DZ_generic_20250311.Singer;

public class Main {
    public static void main(String[] args) {

        FloatCalculator floatCalculator = new FloatCalculator();
        float result1 = floatCalculator.add(2.22f, 5.252554f);
        System.out.println(result1);

        DoubleCalculator doubleCalculator = new DoubleCalculator();
        double result2 = doubleCalculator.sub(254.65, 32.222);
        System.out.println(result2);

        Singer singer = new Singer();
        singer.perform(singer);

        Dancer dancer = new Dancer();
        dancer.perform(dancer);



    }
}