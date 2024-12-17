package co.mahsan;

import co.mahsan.models.Book;
import co.mahsan.models.Library;
import co.mahsan.models.Status;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        Library lib = new Library();
        lib.addBook(new Book("title1", "author1", Timestamp.valueOf(LocalDateTime.now()), Status.EXIST));
        lib.addBook(new Book("title2", "author1", Timestamp.valueOf(LocalDateTime.now()), Status.EXIST));
        lib.addBook(new Book("title3", "author2", Timestamp.valueOf(LocalDateTime.now()), Status.EXIST));
        System.out.println("Initial Values:");
        System.out.println(lib);
    }
}