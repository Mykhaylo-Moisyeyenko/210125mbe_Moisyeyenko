package de.telran.lesson24;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BookStorageTest {

    @Test
    void testAddWhenNewCorrect() {//если книга успешно добавлена:
        Book book = new Book("BookTest", "12345");
        BookStorage bookStorage = new BookStorage();
        bookStorage.add(book);
        assertEquals(1, bookStorage.getSize());

//  void testAddWhenNewCorrect() {//если книги еще нет (и put возвращает null):
//        Book book = new Book("BookTest", "12345");
//        BookStorage bookStorage = new BookStorage();
//        Map<String, Book> storage = new HashMap<>();
//        System.out.println(storage);
//        Book b = storage.put(book.getIsbn(), book);
//        System.out.println(b);
//        assertEquals(null, b);
    }

    @Test
    void testAddWhenExist() {//если книга в Мар уже есть (и put возвращает книгу):
        Book book = new Book("BookTest", "12345");
        BookStorage bookStorage = new BookStorage();
        Map<String, Book> storage = new HashMap<>();
        storage.put(book.getIsbn(), book);
        System.out.println(storage);
        Book b = storage.put(book.getIsbn(), book);
        System.out.println(b);
        assertEquals(book, b);
    }

    @Test
    void testAddWhenBookIsNull() {//если в Мар вместо книги передается null:
        Book book = null;
        BookStorage bookStorage = new BookStorage();
        assertThrows(NullPointerException.class,
                () -> bookStorage.add(book));

//        System.out.println(book);
//        NullPointerException a = new NullPointerException();
//        assertEquals(a, a);//вот тут я не понял, что я ожидаю в результате работы кода и почему тест не проходит
    }

    @Test
    void testAddWhenISBNIsNull() {//если в Мар передается книга, где ISBN = null:
        BookStorage bookStorage1 = new BookStorage();
        Book book1 = new Book("BookTest", null);
        bookStorage1.add(book1);
        System.out.println(bookStorage1);
        assertEquals(0, bookStorage1.getSize());

//        Book book = new Book("BookTest", null);
//        BookStorage bookStorage = new BookStorage();
//        Map<String, Book> storage = new HashMap<>();
//        Book b = storage.put(book.getIsbn(), book);
//        System.out.println(storage);
//        assertEquals("Your ISBN is null, input right ISBN" , b);
    }

    @Test
    void testGetBookWhenIsbnCorrectAndBookExists() {
        Book book = new Book("BookTest", "12345");
        BookStorage bookStorage = new BookStorage();
        bookStorage.add(book);
        Book b = bookStorage.get("12345");
        assertEquals(book, b);
    }

    @Test
    void testGetBookWhenIsbnCorrectAndBookNotExists() {
        BookStorage bookStorage = new BookStorage();
        Book book = new Book("BookTest", "12345");
        bookStorage.add(book);
        assertThrows(IllegalArgumentException.class,
                () -> bookStorage.get("99999"));
//        Book b = bookStorage.get("99999");
//        assertEquals(null, b);//вот тут я не понял почему тест не проходит
    }

    @Test
    void testGetWhenIsbnIsNull() {
        Book book = new Book("BookTest", "12345");
        BookStorage bookStorage = new BookStorage();
        bookStorage.add(book);
        assertThrows(IllegalArgumentException.class,
                () -> bookStorage.get(null));

//        Book b = bookStorage.get(null);
//        assertEquals(null, b);// непонятно почему тест не проходит
    }

    @Test
    void testGetBookWhenIsbnCorrectIsEmpty() {
        Book book = new Book("BookTest", "12345");
        BookStorage bookStorage = new BookStorage();
        bookStorage.add(book);
        assertThrows(IllegalArgumentException.class,
                ()-> bookStorage.get(""));

//        Book b = bookStorage.get("");
//        IllegalArgumentException a = new IllegalArgumentException();
//        assertEquals(a, a);//вот тут я не понял, что я ожидаю в результате работы кода и почему тест не проходит
//        может быть так?:
//        assertEquals("You inputted empty string, input right ISBN", a);

    }
}