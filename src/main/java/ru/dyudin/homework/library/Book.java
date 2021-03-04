package ru.dyudin.homework.library;

public class Book {
    String name;
    String author;
    int part;
    int pages;

    Book(String name, String author, int pages, int part) {
        this.name = name;
        this.author = author;
        this.part = part;
        this.pages = pages;
    }

    Book(String name, String author, int pages) {
        this.name = name;
        this.author = author;
        this.pages = pages;
    }

    @Override
    public String toString() {
        if (part != 0) {
            return "Book: " + this.name + ", author: " + this.author + ", part " + this.part
                    + ", " + this.pages + " pages.";
        }
        return "Book: " + this.name + ", author: " + this.author + ", " + this.pages + " pages.";
    }

}
