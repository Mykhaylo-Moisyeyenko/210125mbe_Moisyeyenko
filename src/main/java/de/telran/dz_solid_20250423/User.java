package de.telran.dz_solid_20250423;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class User {

    private String name;
    private Integer userId;
    private List<String> borrowedBooks = new ArrayList<>();

    public void borrowBook(String isbn){
        borrowedBooks.add(isbn);
    }
    
    public void returnBook(String isbn){
        borrowedBooks.remove(isbn);
    }
}
