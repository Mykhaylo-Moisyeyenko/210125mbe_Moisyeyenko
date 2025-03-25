package de.telran.Lesson12.Tasks;

public class Book {

    private String title;

    private String isbn;

    private int pages;

    private Author author;

    public Book(){}

    public Book(String title, String isbn, int pages, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.pages = pages;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
