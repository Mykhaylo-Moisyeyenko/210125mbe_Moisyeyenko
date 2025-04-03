package de.telran.dz_generic_20250311;

public class IntegerCalculator implements CalculatorGeneric<Integer>{

    @Override
    public Integer add(Integer num1, Integer num2) {
        return num1+num2;
    }

    @Override
    public Integer sub(Integer num1, Integer num2) {
        return num1-num2;
    }

    @Override
    public Integer multi(Integer num1, Integer num2) {
        return num1*num2;
    }

    @Override
    public Integer div(Integer num1, Integer num2) {
        return num1/num2;
    }
}
