package ru.dyudin.homework;

import ru.dyudin.homework.library.Book;
import ru.dyudin.homework.library.Reader;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("title", "famousAuthor", 90);
        Book multipartBook1 = new Book("multipartBookTitle1", "famousAuthor", 50, 1);
        Book multipartBook2 = new Book("multipartBookTitle2", "famousAuthor", 200, 2);
        Book oldBook = new Book("oldTitle", "namelessAuthor", 500);
        Book oldBook2 = new Book("oldTitle", 500);
        Book[] books = {book1, multipartBook1, multipartBook2, oldBook, oldBook2};

        Reader reader = new Reader();
        Book chosenBook = reader.choiceBook(books);
        reader.readBook(chosenBook);
        reader.rateBook(chosenBook);
    }
}