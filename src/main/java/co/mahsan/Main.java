package co.mahsan;

import co.mahsan.models.Book;
import co.mahsan.models.Library;
import co.mahsan.models.Status;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book(
                "The Great Gatsby",
                "F. Scott Fitzgerald",
                Timestamp.valueOf(LocalDateTime.of(1925, 4, 10, 0, 0)),
                Status.EXIST
        );

        Book book2 = new Book(
                "1984",
                "George Orwell",
                Timestamp.valueOf(LocalDateTime.of(1949, 6, 8, 0, 0)),
                Status.EXIST
        );

        Book book3 = new Book(
                "The Catcher in the Rye",
                "J.D. Salinger",
                Timestamp.valueOf(LocalDateTime.of(1951, 7, 16, 0, 0)),
                Status.EXIST
        );

        Book book4 = new Book(
                "Great Expectations",
                "Charles Dickens",
                Timestamp.valueOf(LocalDateTime.of(1861, 8, 1, 0, 0)),
                Status.EXIST
        );

        System.out.println("\n=== Testing adding books ===");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        System.out.println("Total books: " + library.getAllBooks().size());

        System.out.println("\n=== Testing get book by ID ===");
        System.out.println("Book with ID 1: " + library.getBook(1));
        System.out.println("Book with ID 5 (non-existent): " + library.getBook(5));

        System.out.println("\n=== Testing search by title ===");
        System.out.println("Books containing 'Great': " + library.searchBooksByTitle("Great"));

        System.out.println("\n=== Testing search by author ===");
        System.out.println("Books by 'Orwell': " + library.searchBooksByAuthor("Orwell"));

        System.out.println("\n=== Testing general search ===");
        System.out.println("Books matching 'the': " + library.searchBooks("the"));

        System.out.println("\n=== Testing sort by publication date ===");
        System.out.println("Books sorted ascending: ");
        library.sortBooksByPublishDate(true).forEach(book ->
                System.out.println(book.getTitle() + " - " + new Timestamp(book.getPublicationDate()))
        );

        System.out.println("\n=== Testing status changes ===");
        book1.setStatus(Status.BORROWED);
        book2.setStatus(Status.BANNED);
        System.out.println("The Great Gatsby status: " + book1.getStatus());
        System.out.println("1984 status: " + book2.getStatus());

        System.out.println("\n=== Testing book removal ===");
        System.out.println("Books before removal: " + library.getAllBooks().size());
        library.removeBook(1);
        System.out.println("Books after removing ID 1: " + library.getAllBooks().size());

        System.out.println("\n=== Testing get books by author ===");
        System.out.println("Books by Charles Dickens: " + library.getBooksByAuthor("Charles Dickens"));

        System.out.println("\n=== Testing get book by exact title ===");
        System.out.println("Book '1984': " + library.getBookByTitle("1984"));
    }
}