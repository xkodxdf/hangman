package com.xkodxdf.app;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

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
}
