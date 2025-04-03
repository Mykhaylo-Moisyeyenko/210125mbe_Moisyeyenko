package de.telran.lesson16_sorting_objects.dz_sorting;

import java.util.Comparator;

public class AuthorComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.author.name.compareTo(o2.author.name);
    }


}
