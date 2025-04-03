package de.telran.lesson16_sorting_objects.dz_sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BookApp {

    public static void main(String[] args) {
        // 10 books
        //sout(1-Title,2-Pages,3-Author, 4- Year)
        // scanner nextInt
        // sort by )))

        Author author1 = new Author("Tolstoy", 24);
        Author author2 = new Author("Chehov", 75);
        Author author3 = new Author("Nosov", 44);

        Book book1 = new Book("War and peace", 800, 1875, author1);
        Book book2 = new Book("Bezpridannitsa", 152, 1895, author2);
        Book book3 = new Book("Neznajka", 410, 1939, author3);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        System.out.print("Введите порядок сортировки книг (1-Title,2-Pages,3-Author, 4- Year):");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        switch(num){
            case (1):
                Collections.sort(books, new TitleComparator());
                break;
            case (2):
                Collections.sort(books, new PagesComparator());
                break;
            case (3):
                Collections.sort(books, new AuthorComparator());
                break;
            case (4):
                Collections.sort(books, new YearComparator());
                break;
        }
        System.out.println(books);

    }


}
