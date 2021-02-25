package ru.dyudin.homework;

import java.util.Scanner;

public class Operation {

    public static void main(String[] args) {
        while (true) {
            System.out.println("Start");
            Scanner input = new Scanner(System.in);
            String expression = input.nextLine().strip();
            if (expression.equals("stop")){
                break;
            }

            String[] split = expression.split("[ ]+");
            String operator = split[1];

            Operation xyz = new Operation();
            xyz.num1 = Integer.parseInt((split[0]));
            xyz.num2 = Integer.parseInt(split[2]);

            switch (operator) {
                case "+":
                    new Plus().execute(xyz.num1, xyz.num2);
                    break;
                case "-":
                    new Minus().execute(xyz.num1, xyz.num2);
                    break;
                case "*":
                    new Multiply().execute(xyz.num1, xyz.num2);
                    break;
                case "/":
                    new Divide().execute(xyz.num1, xyz.num2);
                    break;
                default:
                    System.out.println("Not supported");
                    return;
            }
        }
    }

    Operation(){
    }

    void execute(int num1, int num2) {
    }

    int num1;
    int num2;


    static class Plus extends Operation {
        Plus() {
        }

        @Override
        void execute(int num1, int num2) {
            System.out.println("Result is " + (num1 + num2));
        }
    }

    static class Minus extends Operation {
        Minus() {
        }

        @Override
        void execute(int num1, int num2) {
            System.out.println("Result is " + (num1 - num2));
        }
    }

    static class Divide extends Operation {
        Divide() {
        }

        @Override
        void execute(int num1, int num2) {
            System.out.println("Result is " + ((double) num1 / num2));
        }
    }

    static class Multiply extends Operation {
        Multiply() {
        }

        @Override
        void execute(int num1, int num2) {
            System.out.println("Result is " + (num1 * num2));
        }
    }
}