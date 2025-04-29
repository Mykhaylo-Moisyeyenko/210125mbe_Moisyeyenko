package de.telran.dz_solid_20250423;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LibraryManager {

    private Library library;

    public void borrowBook(String isbn, User user) {
        user.borrowBook(isbn);
    }

    public void returnBook(String isbn, User user) {
        //логика возврата книги
    }

    public void addBook(Book book) {
        library.addBook(book);
    }

    public void removeBook(Book book) {
        library.removeBook(book);
    }

    public void registerUser(User user) {
        library.registerUser(user);
    }
}
