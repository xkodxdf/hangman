package com.xkodxdf.app.util;

import com.xkodxdf.app.game.Option;

import java.util.*;
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

    public static Option getOption(String askMsg, String invalidInputMsg, Option... options) {
        String input;
        do {
            if (!(askMsg.isBlank())) {
                System.out.println(askMsg);
            }
            input = getInput();
            for (Option o : options) {
                if (Objects.equals(input, o.getValue())) {
                    return o;
                }
            }
            if (!(invalidInputMsg.isBlank())) {
                System.out.println(invalidInputMsg);
            }
        } while (true);
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

    public static void clearCLI() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            ProcessBuilder processBuilder;
            if (os.contains("win")) {
                processBuilder = new ProcessBuilder("cmd", "/c", "cls");
            } else {
                processBuilder = new ProcessBuilder("clear");
            }
            processBuilder.inheritIO().start().waitFor();
        } catch (Exception ignored) {
        }
    }
}
