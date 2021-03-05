package ru.dyudin.homework.library;

import java.util.Random;


public class Reader {
    //Should be chooseBook
    public Book choiceBook(Book[] books) {
        return books[new Random().nextInt(books.length)];
    }

    public void readBook(Book book) {
        System.out.println(book.toString());
    }

    public int rateBook(Book book) {
        int[] bookParams = {book.name.length(), book.author.length(), book.part, book.pages};
        int ratingPenalty = 0;
        for (int i : bookParams) {
            if (i == 0) {
                ratingPenalty += new Random().nextInt();
            }
        }
        int rating = bookParams[0] + bookParams[1] - bookParams[2] + bookParams[3] - ratingPenalty;
        System.out.println("Book " + book.name + " rated for " + rating);
        return rating;
    }
}