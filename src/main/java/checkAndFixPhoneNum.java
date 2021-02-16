public class checkAndFixPhoneNum {
    public static void main(String[] args) {
//        String phoneNum = "+7 (999) 636 44 33";
        String phoneNum = "+7 (999) 636 44 313";
//        String phoneNum = "89996364433";
        String fixedPhoneNum = phoneNum;
        boolean isSpacesRemoved = !phoneNum.equals(phoneNum.replaceAll(" ", ""));
        boolean isBracketsRemoved = !phoneNum.equals(phoneNum.replaceAll("\\(|\\)", ""));

        fixedPhoneNum = fixedPhoneNum.replaceAll(" |\\(|\\)", "");

        boolean isFormatFixed = !fixedPhoneNum.equals(fixedPhoneNum.replace("+7", "8"));

        fixedPhoneNum = fixedPhoneNum.replace("+7", "8");

        if (fixedPhoneNum.length() != 11) {
            System.out.println("Введен некорректный номер");
        } else {
            System.out.println("Исправленный номер телефона: " + fixedPhoneNum);
        }

        String fixesList = "";

        if (isSpacesRemoved) {
            fixesList = fixesList + "Убраны пробелы; ";
        }
        if (isBracketsRemoved) {
            fixesList = fixesList + "Убраны скобки; ";
        }
        if (isSpacesRemoved) {
            fixesList = fixesList + "Исправлен формат; ";
        }
        if (fixesList.equals("")){
            fixesList = fixesList + "Изменений не было";
        }


        System.out.println(fixesList);
        System.out.println("1st is " + phoneNum + " 2nd is " + fixedPhoneNum);
        System.out.println("isSpacesRemoved = " + isSpacesRemoved + " isBracketsRemoved = " + isBracketsRemoved + " isFormatFixed = " + isFormatFixed);
    }
}