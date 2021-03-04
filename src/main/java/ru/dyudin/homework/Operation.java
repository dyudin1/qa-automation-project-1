package ru.dyudin.homework;

import java.util.Locale;
import java.util.Scanner;

public class Operation {

    public void executeOperation() {
        System.out.println("Type \"stop\" to exit");

        while (true) {
            System.out.println("Enter expression to calculate");

            Scanner input = new Scanner(System.in);
            String expression = input.nextLine().strip();

            if (expression.toLowerCase(Locale.ROOT).equals("stop")) {
                break;
            }

            String[] split = expression.split("[ ]+");

            if (split.length != 3) {
                System.out.println("Invalid expression");
                break;
            }

            String operator = split[1];
            Operation xyz = new Operation();

            try {
                xyz.num1 = Integer.parseInt((split[0]));
            } catch (Exception e) {
                System.out.println(e);
                break;
            }

            try {
                xyz.num2 = Integer.parseInt(split[2]);
            } catch (Exception e) {
                System.out.println(e);
                break;
            }

            switch (operator) {
                case "+":
                    System.out.println("Result is " + new Plus().execute(xyz.num1, xyz.num2));
                    break;
                case "-":
                    System.out.println("Result is " + new Minus().execute(xyz.num1, xyz.num2));
                    break;
                case "*":
                    System.out.println("Result is " + new Multiply().execute(xyz.num1, xyz.num2));
                    break;
                case "/":
                    System.out.println("Result is " + new Divide().execute(xyz.num1, xyz.num2));
                    break;
                default:
                    System.out.println(new Operation().execute(xyz.num1, xyz.num2));
                    break;
            }

        }
    }

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