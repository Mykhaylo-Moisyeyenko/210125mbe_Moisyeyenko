package de.telran.DZ_generic_20250311;

public class DoubleCalculator implements CalculatorGeneric<Double>{

    @Override
    public Double add(Double num1, Double num2) {
        return num1+num2;
    }

    @Override
    public Double sub(Double num1, Double num2) {
        return num1-num2;
    }

    @Override
    public Double multi(Double num1, Double num2) {
        return num1*num2;
    }

    @Override
    public Double div(Double num1, Double num2) {
        return num1/num2;
    }
}
