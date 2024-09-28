package com.xkodxdf.app.display;

import com.xkodxdf.app.util.Utils;

import java.util.List;

public class Display {

    public void printGameState(int currentAttempt, int guessedInARow, String[] maskedWord, List<String> usedLetters) {
        int maxAttempts = 6;
        int remainedAttempts = maxAttempts - currentAttempt;
        String attemptWord = Utils.defineAttemptWord(remainedAttempts);

        printHangman(currentAttempt);
        System.out.print(OutputText.REMAIN + remainedAttempts + attemptWord);
        System.out.println(OutputText.GUESSED_WORDS_IN_A_ROW + guessedInARow);
        System.out.println(OutputText.USED_LETTERS + usedLetters);
        printMaskedWord(maskedWord);
    }

    private void printHangman(int attempts) {
        System.out.println(HangmanImage.values()[attempts]);
    }

    private void printMaskedWord(String[] maskedWord) {
        String word = Utils.arrToString(maskedWord);
        System.out.println(OutputText.HIDDEN_WORD + word);
    }

    public void printStartMsg() {
        System.out.println(OutputText.START_GAME_MSG);
    }

    public void printEndGameMsg(int attempts, int guessedInARow, String secretWord, String[] maskedWord, List<String> usedLetters) {
        printGameState(attempts, guessedInARow, maskedWord, usedLetters);
        String word = Utils.arrToString(maskedWord);
        if (word.equals(secretWord)) {
            System.out.println(OutputText.END_GAME_WIN_MSG + word.toUpperCase());
            System.out.println(OutputText.SEPARATOR);
        } else {
            System.out.println(OutputText.END_GAME_LOSS_MSG + secretWord.toUpperCase());
            System.out.println(OutputText.SEPARATOR);
        }
    }

    public void printFileLocationMsg() {
        System.out.println(OutputText.FILE_LOCATION_PROBLEM);
    }

    public void printFileContentProblemMsg() {
        System.out.println(OutputText.FILE_CONTENT_PROBLEM);
    }
}