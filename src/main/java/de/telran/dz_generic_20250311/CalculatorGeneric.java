package de.telran.dz_generic_20250311;

//1. Создайте обобщенный(generic) интерфейс для калькулятора, в котором будут объявлен перечень операций,
//которые умеет делать ваш калькулятор add, sub, multi и div и реализуйте классы, которые
//будут включать данный интерфейс для работы с различными типами данных аргументов.


public interface CalculatorGeneric<T>{

    T add (T num1, T num2);
    T sub (T num1, T num2);
    T multi (T num1, T num2);
    T div (T num1, T num2);


}
