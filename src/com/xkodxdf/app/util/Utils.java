package com.xkodxdf.app.util;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    public static Scanner scn = new Scanner(System.in);


    public static String arrToString(char[] arrWord) {
        return Arrays.toString(arrWord)
                .replace("[", "")
                .replace("]", "")
                .replace(",", "")
                .replace(" ", "")
                .trim();
    }

    public static String getInput() {
        String input = "";
        try {
            input = scn.nextLine();
        } catch (NoSuchElementException e) {
            System.exit(0);
        }

        return input;
    }

    public static boolean isCyrillic(String s) {

        return s.matches(".*\\p{IsCyrillic}.*");
    }

    public static boolean isLatin(String s) {

        return s.matches(".*\\p{IsLatin}.*");
    }

    public static boolean validateRusLetterInput(String letter) {
        if (letter.length() != 1) {
            return false;
        }

        return isCyrillic(letter);
    }

    public static boolean validateEngLetterInput(String letter) {
        if (letter.length() != 1) {
            return false;
        }

        return isLatin(letter);
    }

    public static String openRandomLetter(String word, char[] maskedArr) {
        int randomCell = ThreadLocalRandom.current().nextInt(maskedArr.length);
        maskedArr[randomCell] = word.charAt(randomCell);

        return Utils.arrToString(maskedArr);
    }
}
