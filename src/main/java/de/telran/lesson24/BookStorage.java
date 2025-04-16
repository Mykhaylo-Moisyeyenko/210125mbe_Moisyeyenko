package de.telran.lesson24;

import java.util.HashMap;
import java.util.Map;

public class BookStorage {

    //HashMap - key - isbn, value - Book
    private final Map<String, Book> storage = new HashMap<>();

    public void add(Book book) {
        if (storage.containsKey(book.getIsbn())) {
            System.out.println("This book already exists in storage");
            return;
        }
        if (book.getIsbn()==null){
            System.out.println("Your ISBN is null, input right ISBN");
            return;
        }
        storage.put(book.getIsbn(), book);
    }

    public Book get(String isbn) {
        if (isbn==""){
            throw new IllegalArgumentException("You inputted empty string, input right ISBN");
        }
        if (!storage.containsKey(isbn)) {
            throw new IllegalArgumentException("Isbn is no correct");
        }
        return storage.get(isbn);
    }

    public int getSize(){
        return storage.size();
    }

    @Override
    public String toString() {
        return "BookStorage{" +
                "storage=" + storage +
                '}';
    }
}
