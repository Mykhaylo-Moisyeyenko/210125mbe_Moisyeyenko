package de.telran.DZ_exception_20250314.Task2;

public class WrongLoginException extends Exception{

//    Конструктор по умолчанию
    public WrongLoginException() {
    }

    //2**) второй принимает сообщение исключения и передает его в конструктор класса Exception.
    public WrongLoginException (String message){
        super(message);
    }
}
