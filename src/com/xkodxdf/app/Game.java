package com.xkodxdf.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private final Scanner scn;
    private int attempts;
    private ArrayList<String> usedLetters;


    public Game(Scanner scn) {
        this.scn = scn;
        attempts = 0;
        usedLetters = new ArrayList<>();
    }


    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public ArrayList<String> getUsedLetters() {
        return usedLetters;
    }


    public String chooseSecretWord(ArrayList<String> wordList) {
        int randomPosition = ThreadLocalRandom.current().nextInt(wordList.size());

        return wordList.get(randomPosition);
    }

    public String[] getMaskedWord(String word) {
        String[] arr = new String[word.length()];
        Arrays.fill(arr, "*");

        return arr;
    }

    public String getLetterFromUser() {
        String input;
        char letter;
        do {
            System.out.print("Введите букву: ");
            input = scn.nextLine();
            if (input.length() != 1) {
                System.out.print("Неверный ввод. ");
                continue;
            }
            letter = input.charAt(0);
            if ((letter >= 'A' && letter <= 'Z') || (letter >= 'a' && letter <= 'z')
                    || (letter >= 'А' && letter <= 'Я') || (letter >= 'а' && letter <= 'я')
                    || (letter == 'ё' || letter == 'Ё')) {
                break;
            }
            System.out.print("Неверный ввод. ");
        } while (true);

        return String.valueOf(letter);
    }

    public void saveUsedLetters(String letter) {
        if (!usedLetters.contains(letter.toUpperCase())) {
            usedLetters.add(letter.toUpperCase());
        }
    }

    public void clearUsedLettersList() {
        usedLetters.clear();
    }

    public void changeAttemptCounter(String word, String letter, ArrayList<String> usedLetters) {
        if (word.contains(letter) || usedLetters.contains(letter.toUpperCase())) {
            return;
        }
        attempts++;
    }

    public String[] revealGuessedLetter(String[] maskedWord, String word, String letter) {
        for (int i = 0; i < word.length(); i++) {
            if (String.valueOf(word.charAt(i)).equalsIgnoreCase(letter)) {
                maskedWord[i] = String.valueOf(word.charAt(i));
            }
        }

        return maskedWord;
    }

    public boolean checkWinLose(String[] maskedWord, String secretWord, int attempts) {
        String word = Arrays.toString(maskedWord)
                .replace("[", "")
                .replace("]", "")
                .replace(",", "")
                .replace(" ", "")
                .trim();

        return word.equals(secretWord) || attempts >= 6;
    }

    public boolean continueGame() {
        System.out.println("Начать новую игру - введите 1\n" +
                "Выйти - введите 2");
        String answer;
        do {
            answer = scn.nextLine();
            if (answer.equals("1")) {
                return true;
            }
            if (answer.equals("2")) {
                return false;
            }
            System.out.println("Некорректный ввод.\n" +
                    "Введите 1 - для начала новой игры\n" +
                    "Введите 2 - для завершения игры");
        } while (true);
    }
}
