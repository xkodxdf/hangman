package com.xkodxdf.app;

import java.util.Arrays;

public class Utils {

    public static String arrToString(String[] arrWord) {
        return Arrays.toString(arrWord)
                .replace("[", "")
                .replace("]", "")
                .replace(",", "")
                .replace(" ", "")
                .trim();
    }
}
