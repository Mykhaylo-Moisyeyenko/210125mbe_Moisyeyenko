package de.telran.lesson16_sorting_objects.dz_sorting;

import java.util.Comparator;

public class TitleComparator implements Comparator<Book> {

    @Override
    public int compare(Book book1, Book book2){
        return book1.title.compareTo(book2.title);
    }
}
