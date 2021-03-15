package ru.dyudin.homework.countries;

import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {

        for (Country i : Country.values()) {
            System.out.println(i.toString());
        }
        System.out.println("Type a country code or full name");

        Scanner userInput = new Scanner(System.in);
        String input = userInput.nextLine();

        if (input.equals("")) {
            System.out.println("Input expected");
        } else {

            Country country = null;

            try {
                country = Country.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Country code not found");
            }
            if (country == null) {
                try {
                    country = Country.getByName(input);
                } catch (NoSuchCountryException e) {
                    System.out.println("Country " + input + " not found");
                }
            }

            try {
                System.out.println("Country " + country.getEnName()
                        + ((country.getIsOpen()) ? " is opened" : " is closed"));
            } catch (NullPointerException e) {
                System.out.println("Unknown " + input + " country");
            } finally {
                System.out.println("Finishing program run");
            }
        }
    }
}