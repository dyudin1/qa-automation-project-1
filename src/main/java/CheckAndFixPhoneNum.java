import java.util.Arrays;

public class CheckAndFixPhoneNum {
    private static String[] fixNumber(String phoneNum) {

        boolean isSpacesRemoved = phoneNum.contains(" ");
        boolean isBracketsRemoved = phoneNum.contains(")") || phoneNum.contains("(");

        phoneNum = phoneNum.replaceAll(" |\\(|\\)", "");

        boolean isFormatFixed = phoneNum.startsWith("+7");

        phoneNum = phoneNum.replace("+7", "8");

        if (phoneNum.length() != 11) {
            phoneNum = "Введен некорректный номер";
        }

        String fixesList = "";

        if (isSpacesRemoved) {
            fixesList = fixesList + "Убраны пробелы; ";
        }
        if (isBracketsRemoved) {
            fixesList = fixesList + "Убраны скобки; ";
        }
        if (isFormatFixed) {
            fixesList = fixesList + "исправлен формат;";
        }
        if (fixesList.equals("")) {
            fixesList = fixesList + "исправлений не было";
        }

        return new String[]{phoneNum, fixesList};
    }

    public static void main(String[] args) {

        String phoneNum1 = "+7 (999) 636 44 33";
        String phoneNum2 = "+7 999 636 44 313";
        String phoneNum3 = "89996364433";

        System.out.println(Arrays.asList(fixNumber(phoneNum1)));
        System.out.println(Arrays.asList(fixNumber(phoneNum2)));
        System.out.println(Arrays.asList(fixNumber(phoneNum3)));

    }
}