package de.telran.dz_solid_20250423;

//Задача: Создание системы управления библиотекой с использованием принципов SOLID
//Описание задачи:
//Вы работаете в компании, занимающейся разработкой программного обеспечения для управления библиотеками.
//Ваша задача - создать систему классов, которая будет соответствовать принципам SOLID
//и позволит эффективно управлять библиотекой. Основные функции системы включают добавление новых книг,
//учет взятых и возвращенных книг.
//
//Описание классов:
//Book:
//Поля: title, author, isbn, availableCopies
//
//
//User:
//Поля: name, userId, borrowedBooks
//Методы:  borrowBook(Book book), returnBook(Book book) - методы для добавления и удаления книг из borrowedBooks
//
//
//Library:
//Поля: books, users
//Методы: addBook(Book book), removeBook(Book book), registerUser(User user), findBookByIsbn(String isbn)
//
//
//LibraryManager:
//Поля: library
//Методы: borrowBook(String isbn, User user), returnBook(String isbn, User user),
//addBook(Book book), removeBook(Book book), registerUser(User user)

import java.util.ArrayList;

public class LibraryApp {
    public static void main(String[] args) {
        Book book1 = new Book("War and peace", "Lev Tolstoy", "12345", 3);
        Book book2 = new Book("Master and Margarita", "Mikhail Bulgakov", "6789", 5);

        LibraryManager libraryManager = new LibraryManager(new Library());

        User user1 = new User("Misha Moisyeyenko", 1, new ArrayList<String>());
        User user2 = new User("Ivan Ivanov", 2, new ArrayList<String>());

        libraryManager.addBook(book1);
        libraryManager.addBook(book2);

        libraryManager.registerUser(user1);
        libraryManager.registerUser(user2);

        libraryManager.borrowBook("12345", user1);
        //через время:
        libraryManager.returnBook("12345", user1);
    }

}
