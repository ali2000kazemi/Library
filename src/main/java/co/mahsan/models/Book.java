package co.mahsan.models;

import java.sql.Timestamp;

public class Book {
    private final int id;
    private String title;
    private String author;
//    private long publishTimestamp;
    private Timestamp publicationDate;
    private Status status;

    private static int idCounter = 0;

    public Book(String title, String author, Timestamp publicationDate, Status status) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.status = status;
        this.id = ++idCounter;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public long getPublicationDate() {
        return publicationDate.getTime();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title=" + title +
                ", author='" + author + '\'' +
                ", status=" + status +
                '}';
    }
}
