package ru.dyudin.homework;

import java.util.Arrays;

public class CheckAndFixPhoneNum {
    static String[] fixNumber(String phoneNum) {

        boolean isSpacesRemoved = phoneNum.contains(" ");
        boolean isBracketsRemoved = phoneNum.contains(")") || phoneNum.contains("(");

        phoneNum = phoneNum.replaceAll("\\s|\\(|\\)", "");

        boolean isFormatFixed = phoneNum.startsWith("+7");

        phoneNum = phoneNum.replace("+7", "8");

        if (phoneNum.length() != 11) {
            phoneNum = "Incorrect number";
        }

        String fixesList = "";

        if (isSpacesRemoved) {
            fixesList += "Removed spaces; ";
        }
        if (isBracketsRemoved) {
            fixesList += "Removed brackets; ";
        }
        if (isFormatFixed) {
            fixesList += "Fixed format;";
        }
        if (fixesList.isEmpty()) {
            fixesList += "No fixes applied";
        }

        return new String[]{phoneNum, fixesList};
    }

}