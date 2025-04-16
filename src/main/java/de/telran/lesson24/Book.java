package de.telran.lesson24;

import lombok.Getter;

@Getter
public class Book {

    private String title;

    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }
}
