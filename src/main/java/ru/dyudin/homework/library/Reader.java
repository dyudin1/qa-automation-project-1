package ru.dyudin.homework.library;

import java.util.Random;


public class Reader {

    public void executeReader() {
        Reader reader = new Reader();
        Book chosenBook = reader.chooseBook(reader.books);
        reader.readBook(chosenBook);
        reader.rateBook(chosenBook);
    }

    Book book1 = new Book("title", "famousAuthor", 90);
    Book multipartBook1 = new Book("multipartBookTitle1", "famousAuthor", 50, 1);
    Book multipartBook2 = new Book("multipartBookTitle2", "famousAuthor", 200, 2);
    Book oldBook = new Book("oldTitle", "namelessAuthor", 500);
    Book[] books = new Book[]{book1, multipartBook1, multipartBook2, oldBook};

    private Book chooseBook(Book[] books) {
        return books[new Random().nextInt(books.length - 1)];
    }

    private void readBook(Book book) {
        System.out.println(book.toString());
    }

    private int rateBook(Book book) {
        int rating = book.name.length() + book.author.length() - book.part + book.pages;
        System.out.println("Book " + book.name + " rated for " + rating);
        return rating;
    }
}