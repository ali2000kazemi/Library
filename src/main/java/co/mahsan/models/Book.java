package co.mahsan.models;

public class Book {
    private final int id;
    private String title;
    private String author;
    private long publishTimestamp;
    private Status status;

    public static int idCounter = 0;

    public Book(String title, String author, long publishTimestamp, Status status) {
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

    public long getPublishTimestamp() {
        return publishTimestamp;
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
