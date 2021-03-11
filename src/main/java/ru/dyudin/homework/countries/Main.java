package ru.dyudin.homework.countries;

import java.util.Scanner;

public class Main {
    public static void main(final String[] args) throws Country.NoSuchCountryException {

        for (Country i : Country.values()) {
            System.out.println(i.toString());
        }
        System.out.println("Type a country code or full name");

        Scanner userInput = new Scanner(System.in);
        String input = userInput.nextLine();

        if (input.equals("")) {
            throw new NullPointerException("Input expected");
        }

        try {
            Country.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Country code not found");
            Country.getByName(input);
        }

        System.out.println("Country " + Country.getByName(input).getEnName()
                + ((Country.getByName(input).getIsOpen()) ? " is opened" : " is closed"));
    }

}