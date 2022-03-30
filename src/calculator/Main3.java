package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main3 {
    static Scanner scanner = new Scanner(System.in);
    static private int number1, number2;
    static private char operation;
    static private int result;

    public static void main(String[] args) {

        char[] underChar = getChars();

        String underCharString = String.valueOf(underChar);
        String[] blacks = underCharString.split("[+-/*]");
        String string00 = blacks[0];
        String string01 = blacks[1];
        String string03 = string01.trim();
        number1 = romanToNumber(string00);
        number2 = romanToNumber(string03);

            calculateResultOfRomanNumbers(string00, string03);
            calculateResultOfArabianNumbers(string00, string03);
    }

    private static char[] getChars() {
        System.out.println("Сандардын туюнтмасын киргизиңиз [2+2] же эки рим цифрасы I ден X чейин:[V+V] + Enter ");
        String userInput = scanner.nextLine();

        char[] underChar = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            underChar[i] = userInput.charAt(i);
            if (underChar[i] == '+') {
                operation = '+';
            }
            if (underChar[i] == '-') {
                operation = '-';
            }
            if (underChar[i] == '*') {
                operation = '*';
            }
            if (underChar[i] == '/') {
                operation = '/';
            }
        }
        return underChar;
    }

    private static void calculateResultOfRomanNumbers(String string00, String string03) {
                if (number1 < 0 && number2 < 0) {
                    result = 0;
                } else {
                    result = calculated(number1, number2, operation);
                    System.out.println("---Рим сандары үчүн жыйынтык----");
                    String resultRoman = convertNumToRoman(result);
                    System.out.println(string00 + " " + operation + " " + string03 + " = " + resultRoman);
                }
    }

    private static void calculateResultOfArabianNumbers(String string00, String string03) {
        try {
            number1 = Integer.parseInt(string00);
            number2 = Integer.parseInt(string03);
            result = calculated(number1, number2, operation);
            System.out.println("--Араб сандары үчүн жыйынтык----");
            System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
        }catch (NumberFormatException e) {
        }

    }

    private static String convertNumToRoman(int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }

    private static int romanToNumber(String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
            return -1;
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Туура эмес берилген формат");
        }
    }

    private static int calculated(int num1,int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                }catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Өзгөчө учурлар : " + e);
                    System.out.println("Бир гана бүтүн сан нөл эмес параметрлерге уруксат берилет");
                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Туура эмес жазылган белги");
        }
        return result;
    }
}
