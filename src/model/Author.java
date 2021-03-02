package model;

public class Author {
    String name;

    public Author(String name) {
        this.name = name;
    }

    public void writeNew(Book book, Genre genre) {
        book.author = this.name;
        book.genre = genre;
        book.isFinished = false;
    }

    public void finishBook(Book book) {
        book.isFinished = true;
    }

}