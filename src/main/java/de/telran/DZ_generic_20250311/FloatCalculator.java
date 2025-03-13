package de.telran.DZ_generic_20250311;

public class FloatCalculator implements CalculatorGeneric<Float>{

    @Override
    public Float add(Float num1, Float num2) {
        return num1+num2;
    }

    @Override
    public Float sub(Float num1, Float num2) {
        return num1-num2;
    }

    @Override
    public Float multi(Float num1, Float num2) {
        return num1*num2;
    }

    @Override
    public Float div(Float num1, Float num2) {
        return num1/num2;
    }
}
