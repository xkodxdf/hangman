package com.xkodxdf.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scn = new Scanner(System.in);
    private static final Display display = new Display();
    private static final Dictionary dictionary = new Dictionary();
    private static final Game game = new Game(scn);

    public static void main(String[] args) {
        try {
            dictionary.setWordList();
        } catch (IOException e) {
            System.out.println("Проверьте расположение файла \"src/resources/data.txt\"");
            System.exit(0);
        }

        List<String> wordList = new ArrayList<>(dictionary.getWordList());

        while (game.continueGame()) {
            String letter;
            String secretWord = null;
            try {
                secretWord = game.chooseSecretWord(wordList);
            } catch (IllegalArgumentException e) {
                System.out.println("Файл \"src/resources/data.txt\" должен содержать слова. По одному слову на каждой строке.");
                System.exit(0);
            }
            String[] maskedWord = game.getMaskedWord(secretWord);
            display.printStartMessage();

            while (true) {
                display.printGameState(game.getAttempts(), maskedWord, game.getUsedLetters());
                letter = game.getLetterFromUser();
                game.changeAttemptCounter(secretWord, letter, game.getUsedLetters());
                game.saveUsedLetters(letter);
                maskedWord = game.revealGuessedLetter(maskedWord, secretWord, letter);
                if (game.checkWinLose(maskedWord, secretWord, game.getAttempts())) {
                    display.printEndGameMessage(game.getAttempts(), secretWord, maskedWord, game.getUsedLetters());
                    break;
                }
            }

            boolean wordGuessed = game.isMaskedWordEqualsSecret(maskedWord, secretWord);
            if (wordGuessed && wordList.size() == 1) {
                wordList = new ArrayList<>(dictionary.getWordList());
            } else if (wordGuessed) {
                wordList.remove(secretWord);
            }

            game.resetAttempts();
            game.clearUsedLettersList();
        }

        scn.close();
    }
}