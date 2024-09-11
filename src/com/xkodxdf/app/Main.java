package com.xkodxdf.app;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final Scanner scn = new Scanner(System.in);
    private static final Display display = new Display();
    private static final Dictionary dictionary = new Dictionary();
    private static final Game game = new Game(scn);

    public static void main(String[] args) throws IOException {
        dictionary.setWordList();
        while (game.continueGame()) {
            String letter;
            String secretWord = game.chooseSecretWord(dictionary.getWordList());
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

            game.setAttempts(0);
            game.clearUsedLettersList();
        }
    }
}