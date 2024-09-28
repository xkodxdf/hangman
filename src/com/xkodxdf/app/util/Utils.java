package com.xkodxdf.app.util;

import com.xkodxdf.app.display.OutputText;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static String arrToString(String[] arrWord) {
        return Arrays.toString(arrWord)
                .replace("[", "")
                .replace("]", "")
                .replace(",", "")
                .replace(" ", "")
                .trim();
    }

    public static String getInput(Scanner scn) {
        String input = "";
        try {
            input = scn.nextLine();
        } catch (NoSuchElementException e) {
            System.exit(0);
        }

        return input;
    }

    public static String defineAttemptWord(int remainedAttempts) {
        if (remainedAttempts > 1 && remainedAttempts < 5) {
            return OutputText.ATTEMPT_V2;
        }
        if (remainedAttempts == 1) {
            return OutputText.ATTEMPT_V3;
        }

        return OutputText.ATTEMPT_V1;
    }

    public static boolean validateRusLetterInput(String letter) {
        if (letter.length() != 1) {
            return false;
        }
        Pattern alphabet = Pattern.compile("[а-яёА-ЯЁ]");
        Matcher matcher = alphabet.matcher(letter);

        return matcher.find();
    }

    public static boolean validateEngLetterInput(String letter) {
        if (letter.length() != 1) {
            return false;
        }
        Pattern alphabet = Pattern.compile("[a-zA-Z]");
        Matcher matcher = alphabet.matcher(letter);

        return matcher.find();
    }
}
