package de.telran.lesson16_sorting_objects.dz_sorting;

import java.util.Comparator;

public class YearComparator implements Comparator<Book> {

    @Override
    public int compare(Book book1, Book book2){
        return Integer.compare(book1.year, book2.year);
    }
}
