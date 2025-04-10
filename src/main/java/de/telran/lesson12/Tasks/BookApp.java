package de.telran.lesson12.Tasks;

public class BookApp {

    // book one : title Book, isbn "12345", pages 150, Author :"Author", age 50, city Berlin
// book two : title Book, isbn "12345", pages 150, Author :"Author", age 50, city Berlin

    //bookOne.equals(bookTwo) -> true
    public static void main(String[] args) {

        City city1 = new City("Berlin");
        City city2 = new City("Berlin");
        Author author1 = new Author("Author", 50, city1);
        Author author2 = new Author("Author", 50, city2);
        Book bookOne = new Book("Book", "12345", 150, author1);
        Book bookTwo = new Book("Book", "12345", 150, author2);

        System.out.println(city1.equals(city2));





    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}

