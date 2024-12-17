package co.mahsan.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Library {
    private final List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public List<Book> getAllBooks() {
        return new ArrayList<Book>(this.books);
    }

    public Book getBook(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(int id) {
        this.books.removeIf(b -> b.getId() == id);
    }

    public Book getBookByTitle(String title) {
        return books.stream().filter(b -> b.getTitle().equals(title)).findFirst().orElse(null);
    }

    public List<Book> getBooksByAuthor(String author) {
        return books.stream().filter(b -> b.getAuthor().equals(author)).toList();
    }

    public List<Book> searchBooksByTitle(String title) {
        return books.stream().filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase())).toList();
    }

    public List<Book> searchBooksByAuthor(String author) {
        return books.stream().filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase())).toList();
    }

    public List<Book> searchBooks(String searchStr) {
        String searchTerm = searchStr.toLowerCase();
        return books.stream().filter(book -> book.getTitle().toLowerCase().contains(searchTerm) || book.getAuthor().toLowerCase().contains(searchTerm)).toList();
    }

    public List<Book> sortBooksByPublishDate(boolean asc) {
        return this.books.stream().sorted(Comparator.comparingLong(Book::getPublicationDate)).toList();
    }

    public List<Book> sortBooksByPublishDate() {
        return sortBooksByPublishDate(true);
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }
}
