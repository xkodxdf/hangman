package com.xkodxdf.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    //TODO
    // - рисунки висельника запихнуть в енам
    // - весь выводимый текст запихнуть в енам
    // - словарь со значениями в мапе
    // - проверить классы и методы на возможность разбиения
    // - проверить нэйминг
    // - регулярные выражения
    // - тесты

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
            boolean wordGuessed;
            try {
                secretWord = game.chooseSecretWord(wordList);
            } catch (IllegalArgumentException e) {
                System.out.println("Файл \"src/resources/data.txt\" должен содержать слова. По одному слову на каждой строке.");
                System.exit(0);
            }
            String[] maskedWord = game.getMaskedWord(secretWord);
            display.printStartMessage();

            while (true) {
                display.printGameState(game.getAttempts(), game.getGuessedInARow(), maskedWord, game.getUsedLetters());
                letter = game.getLetterFromUser();
                game.changeAttemptCounter(secretWord, letter, game.getUsedLetters());
                game.saveUsedLetters(letter);
                maskedWord = game.revealGuessedLetter(maskedWord, secretWord, letter);
                wordGuessed = game.isMaskedWordEqualsSecret(maskedWord, secretWord);
                if (game.checkWinLose(wordGuessed, game.getAttempts())) {
                    game.changeGuessedInARowCounter(wordGuessed);
                    display.printEndGameMessage(game.getAttempts(), game.getGuessedInARow(), secretWord, maskedWord, game.getUsedLetters());
                    break;
                }
            }

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