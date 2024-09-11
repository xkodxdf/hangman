package com.xkodxdf.app;

import java.util.ArrayList;
import java.util.Arrays;

public class Display {

    private final String[] hangman = {
            "    +---+\n" +
                    "    |   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    =========",

            "    +---+\n" +
                    "    |   |\n" +
                    "    |   O\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    =========",

            "    +---+\n" +
                    "    |   |\n" +
                    "    |   O\n" +
                    "    |   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    =========",

            "    +---+\n" +
                    "    |   |\n" +
                    "    |   O\n" +
                    "    |  /|\n" +
                    "    |\n" +
                    "    |\n" +
                    "    =========",

            "    +---+\n" +
                    "    |   |\n" +
                    "    |   O\n" +
                    "    |  /|\\\n" +
                    "    |\n" +
                    "    |\n" +
                    "    =========",

            "    +---+\n" +
                    "    |   |\n" +
                    "    |   O\n" +
                    "    |  /|\\\n" +
                    "    |  /\n" +
                    "    |\n" +
                    "    =========",

            "    +---+\n" +
                    "    |   |\n" +
                    "    |   O\n" +
                    "    |  /|\\\n" +
                    "    |  / \\\n" +
                    "    |\n" +
                    "    ========="};


    public void printGameState(int currentAttempt, String[] maskedWord, ArrayList<String> usedLetters) {
        int maxAttempts = 6;
        printHangman(currentAttempt);
        System.out.println("Осталось " + (maxAttempts - currentAttempt) + " попыток");
        System.out.println("Буквы которые вы уже вводили: " + usedLetters);
        printMaskedWord(maskedWord);
    }

    private void printHangman(int attempts) {
        System.out.println(hangman[attempts] + "\n");
    }

    private void printMaskedWord(String[] maskedWord) {
        String word = Arrays.toString(maskedWord)
                .replace("[", "")
                .replace("]", "")
                .replace(",", "")
                .replace(" ", "")
                .trim();
        System.out.println("Загаданное слово: " + word);
    }

    public void printStartMessage() {
        System.out.println("Игра Виселица\n" +
                "Цель - угадать загаданное слово. Даётся 6 попыток.\n" +
                "Если вы угадали букву или случайно ввели букву, которую уже вводили ранее - попытка не тратится.\n");
    }

    public void printEndGameMessage(int attempts, String secretWord, String[] maskedWord, ArrayList<String> usedLetters) {
        printGameState(attempts, maskedWord, usedLetters);
        String word = Arrays.toString(maskedWord)
                .replace("[", "")
                .replace("]", "")
                .replace(",", "")
                .replace(" ", "")
                .trim();
        if (word.equals(secretWord)) {
            System.out.println("\nИгра окончена. Вы победили, угадав слово - " + word.toUpperCase() + ".");
            System.out.println("_".repeat(50) + "\n");
        } else {
            System.out.println("\n11Игра окончена. Вы проиграли!");
            System.out.println("Было загадано слово: " + secretWord.toUpperCase() + ".");
            System.out.println("_".repeat(50) + "\n");
        }
    }
}