package de.telran.DZ_exception_20250314.Task2;

public class WrongPasswordException extends Exception{

    //    Конструктор по умолчанию
    public WrongPasswordException() {
    }

    //2**) второй принимает сообщение исключения и передает его в конструктор класса Exception.
    public WrongPasswordException(String message) {
        super(message);
    }




}
