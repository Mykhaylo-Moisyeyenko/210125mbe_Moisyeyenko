package de.telran.lesson24;

import java.util.Scanner;

public class HMTask {

    public static void main(String[] args) {
        // create 3 book
        // put in storage
        BookStorage bookStorage = new BookStorage();
//        bookStorage.add(new Book("One", "12345"));
        bookStorage.add(null);
        bookStorage.add(new Book("Two", "32455"));
        bookStorage.add(new Book("Three", "32451"));
        // etc

        System.out.println("Input isbn :");
        Scanner scanner = new Scanner(System.in);
        String isbn = scanner.next();
        try{
            Book book = bookStorage.get(isbn);
            System.out.println(book);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
