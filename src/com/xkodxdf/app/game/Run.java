package com.xkodxdf.app.game;

import com.xkodxdf.app.dictionary.Dictionary;
import com.xkodxdf.app.display.Display;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Run {

    private static final Scanner scn = new Scanner(System.in);
    private static final Display display = new Display();
    private static final Dictionary dictionary = new Dictionary();
    private static final Game game = new Game(scn);

    public static void main(String[] args) {
        try {
            dictionary.setWordList();
        } catch (IOException e) {
            display.printFileLocationMsg();
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
                display.printFileContentProblemMsg();
                System.exit(0);
            }
            String[] maskedWord = game.getMaskedWord(secretWord);
            display.printStartMsg();

            while (true) {
                display.printGameState(game.getAttempts(), game.getGuessedInARow(), maskedWord, game.getUsedLetters());
                letter = game.getLetterFromUser();
                game.changeAttemptCounter(secretWord, letter, game.getUsedLetters());
                game.saveUsedLetters(letter);
                maskedWord = game.revealGuessedLetter(maskedWord, secretWord, letter);
                wordGuessed = game.isMaskedWordEqualsSecret(maskedWord, secretWord);
                if (game.checkWinLoss(wordGuessed, game.getAttempts())) {
                    game.changeGuessedInARowCounter(wordGuessed);
                    display.printEndGameMsg(game.getAttempts(), game.getGuessedInARow(), secretWord, maskedWord, game.getUsedLetters());
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