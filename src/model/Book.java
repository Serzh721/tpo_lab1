package model;

public class Book {
    Genre genre;
    String author;
    boolean isFinished;
    public boolean isInteresting;
    public Information information;

    public Book() {
    }

    public boolean isInteresting() {
        return isInteresting;
    }

    public boolean containsInfo() {
        return information != null;
    }

}