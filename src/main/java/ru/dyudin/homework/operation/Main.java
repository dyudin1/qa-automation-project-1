package ru.dyudin.homework.operation;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
                    System.out.println("Result is " + new Operation.Plus().execute(xyz.num1, xyz.num2));
                    break;
                case "-":
                    System.out.println("Result is " + new Operation.Minus().execute(xyz.num1, xyz.num2));
                    break;
                case "*":
                    System.out.println("Result is " + new Operation.Multiply().execute(xyz.num1, xyz.num2));
                    break;
                case "/":
                    System.out.println("Result is " + new Operation.Divide().execute(xyz.num1, xyz.num2));
                    break;
                default:
                    System.out.println(new Operation().execute(xyz.num1, xyz.num2));
                    break;
            }

        }
    }
}