package de.telran.lesson24.calcexample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testSum() {
        Calculator calculator = new Calculator();
        int sum = calculator.sum(2, 3);
        assertEquals(5, sum);
    }

    @Test
    void testSub() {
        Calculator calculator = new Calculator();
        int sub = calculator.sub(6, 3);
        assertEquals(3, sub);
    }

    @Test
    void testMult() {
        Calculator calculator = new Calculator();
        int mult = calculator.mult(2, 3);
        assertEquals(6, mult);
    }

    @Test
    void testDiv() {
        Calculator calculator = new Calculator();
        int result = calculator.div(6,0);
        assertEquals(0, result);
    }



}