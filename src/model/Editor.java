package model;

public class Editor {
    String name;

    public Editor(String name) {
        this.name = name;
    }

    public void criticizeBook(Book book) {
        if (book.isFinished)
            book.isInteresting = false;
    }

    public void likeBook(Book book) {
        if (book.isFinished && book.containsInfo())
            book.isInteresting = true;
    }
}