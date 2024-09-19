package com.xkodxdf.app;

import java.util.List;

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


    protected void printGameState(int currentAttempt, int guessedInARow, String[] maskedWord, List<String> usedLetters) {
        int maxAttempts = 6;
        int remainedAttempts = maxAttempts - currentAttempt;
        String attemptWord = " попыток";

        if (remainedAttempts > 1 && remainedAttempts < 5) {
            attemptWord = " попытки";
        }
        if (remainedAttempts == 1) {
            attemptWord = " попытка";
        }

        printHangman(currentAttempt);
        System.out.print("Осталось " + remainedAttempts + attemptWord);
        System.out.println("  |  Угадано слов подряд: " + guessedInARow);
        System.out.println("Буквы которые вы уже вводили: " + usedLetters);
        printMaskedWord(maskedWord);
    }

    private void printHangman(int attempts) {
        System.out.println(hangman[attempts] + "\n");
    }

    private void printMaskedWord(String[] maskedWord) {
        String word = Utils.arrToString(maskedWord);
        System.out.println("Загаданное слово: " + word);
    }

    protected void printStartMessage() {
        System.out.println("Игра Виселица\n"
                + "Цель - угадать загаданное слово по буквам. Даётся 6 попыток.\n"
                + "В словах длиной больше 7 букв - одна из букв открыта с самого начала."
                + "Если вы угадали или случайно ввели букву, которую уже вводили ранее - попытка не тратится.\n");
    }

    protected void printEndGameMessage(int attempts, int guessedInARow, String secretWord, String[] maskedWord, List<String> usedLetters) {
        printGameState(attempts, guessedInARow, maskedWord, usedLetters);
        String word = Utils.arrToString(maskedWord);
        if (word.equals(secretWord)) {
            System.out.println("\nИгра окончена. Вы победили, угадав слово - " + word.toUpperCase() + ".");
            System.out.println("_".repeat(50) + "\n");
        } else {
            System.out.println("\nИгра окончена. Вы проиграли!");
            System.out.println("Было загадано слово: " + secretWord.toUpperCase() + ".");
            System.out.println("_".repeat(50) + "\n");
        }
    }
}