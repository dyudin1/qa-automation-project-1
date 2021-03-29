package ru.dyudin.homework.process;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        int inputResult = Integer.parseInt(input.nextLine());
        int arraySize = inputResult * 2;

        System.out.println(Arrays.toString(getFilledArray(arraySize, inputResult, Integer::sum)));
        System.out.println(Arrays.toString(getFilledArray(arraySize, inputResult, (a, b) -> a * b)));
        System.out.println(Arrays.toString(getFilledArray(arraySize, inputResult,
                (a, b) -> a % 2 != 0 ? b / 2 + a : b * b - a)));
        //Модификатор возводится в степень индекса
        System.out.println(Arrays.toString(getFilledArray(arraySize, inputResult, (a, b) -> (int) Math.pow(a, b))));
        //Остаток от деления модификатора на индекс
        System.out.println(Arrays.toString(getFilledArray(arraySize, inputResult, (a, b) -> b != 0 ? a % b : a)));
    }

    private static int[] getFilledArray(final int arraySize, final int input, final Foo process) {
        return IntStream
                .range(0, arraySize)
                .map(x -> process.process(input, x))
                .toArray();
    }


    @FunctionalInterface
    interface Foo {
        int process(int value, int value2);
    }
}