package de.telran.lesson24;

import java.util.Scanner;

public class HMTask {

    public static void main(String[] args) {
        // create 3 book
        // put in storage
        BookStorage bookStorage = new BookStorage();
        bookStorage.add(new Book("One", "12345"));
        bookStorage.add(new Book("Two", "32455"));
        bookStorage.add(new Book("Three", "32451"));
        // etc

        Scanner scanner = new Scanner(System.in);
        String isbn = scanner.next();
        Book book = bookStorage.get(isbn);
        System.out.println(book);
    }
}
