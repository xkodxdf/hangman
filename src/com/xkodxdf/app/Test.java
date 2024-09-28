package com.xkodxdf.app;

import com.xkodxdf.app.util.Utils;

public class Test {

    public static void main(String[] args) {
        System.out.println(Utils.validateRusLetterInput("а"));
        System.out.println(Utils.validateRusLetterInput("в"));
        System.out.println(Utils.validateRusLetterInput("ё"));
        System.out.println(Utils.validateRusLetterInput("Ё"));
        System.out.println(Utils.validateRusLetterInput("А"));
        System.out.println();
        System.out.println(Utils.validateRusLetterInput("ёА"));
        System.out.println(Utils.validateRusLetterInput("аб"));
        System.out.println(Utils.validateRusLetterInput("d"));
        System.out.println(Utils.validateRusLetterInput("2"));
    }
}
