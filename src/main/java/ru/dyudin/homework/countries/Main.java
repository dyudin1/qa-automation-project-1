package ru.dyudin.homework.countries;

import java.util.Locale;
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

        Country country;

        try {
            country = Country.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Country code not found");
            country = Country.getByName(input);
        }

        System.out.println("Country " + country.getEnName()
                + ((country.getIsOpen()) ? " is opened" : " is closed"));
    }

}