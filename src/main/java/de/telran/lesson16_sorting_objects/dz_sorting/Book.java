package de.telran.lesson16_sorting_objects.dz_sorting;

public class Book {

    public String title;

    public int pages;

    public int year;

    public Author author;

    public Book(String title, int pages, int year, Author author) {
        this.title = title;
        this.pages = pages;
        this.year = year;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book: " + title +"; "+ pages +"; "+ year +"; "+ author.name+"; "+ author.age+"; ";
    }
}
