package ru.dyudin.homework;

import java.util.Arrays;

import static ru.dyudin.homework.CheckAndFixPhoneNum.fixNumber;

public class main {
    public static void main(String[] args) {

        //Проверки исправления номера
        System.out.println(Arrays.asList(fixNumber("+7 (999) 636 44 33")));
        System.out.println(Arrays.asList(fixNumber("+7 999 636 44 313")));
        System.out.println(Arrays.asList(fixNumber("89996364433")));

    }
}
