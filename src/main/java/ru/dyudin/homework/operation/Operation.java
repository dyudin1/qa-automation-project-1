package ru.dyudin.homework.operation;

import java.util.Locale;
import java.util.Scanner;

public class Operation {

    String execute(int num1, int num2) {
        return "Not supported";
    }

    int num1;
    int num2;

    static class Plus extends Operation {

        @Override
        String execute(int num1, int num2) {
            return String.valueOf(num1 + num2);
        }

    }

    static class Minus extends Operation {

        @Override
        String execute(int num1, int num2) {
            return String.valueOf(num1 - num2);
        }

    }

    static class Divide extends Operation {

        @Override
        String execute(int num1, int num2) {
            return String.valueOf((double) num1 / num2);
        }

    }

    static class Multiply extends Operation {

        @Override
        String execute(int num1, int num2) {
            return String.valueOf(num1 * num2);
        }

    }
}