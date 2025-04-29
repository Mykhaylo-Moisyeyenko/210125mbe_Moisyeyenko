package de.telran.dz_solid_20250423;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Book {
    private String title;
    private String author;
    private String isbn;
    private int availableCopies;
}
