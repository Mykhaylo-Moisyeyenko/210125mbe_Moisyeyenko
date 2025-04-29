package de.telran.dz_solid_20250423;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<Book>();
    private HashMap<Integer, String> users = new HashMap<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void registerUser(User user) {
        users.put(user.getUserId(), user.getName());
    }

    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
}
