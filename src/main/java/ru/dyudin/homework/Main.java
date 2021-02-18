package ru.dyudin.homework;

import java.util.Arrays;

import static ru.dyudin.homework.CheckAndFixPhoneNum.fixNumber;
import static ru.dyudin.homework.ThanosSort.*;

public class Main {
    public static void main(String[] args) {

        //Проверки исправления номера
//        System.out.println(Arrays.asList(fixNumber("+7 (999) 636 44 33")));
//        System.out.println(Arrays.asList(fixNumber("+7 999 636 44 313")));
//        System.out.println(Arrays.asList(fixNumber("89996364433")));

        //Проверка сортировки
        int[] notSortedArray = {97, 25, 42, 90, 71, 16, 82, 39, 36, 74};
        int[] notSortedArray2 = {35, 11, 92, 13, 54, 72, 65, 91, 10, 5, 24, 64, 6};
        System.out.println(Arrays.toString(sortByHalves(notSortedArray)));
        System.out.println(Arrays.toString(sortByHalves(notSortedArray2)));

    }
}
