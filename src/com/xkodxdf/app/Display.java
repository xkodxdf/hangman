package com.xkodxdf.app;

import java.util.List;

public class Display {

    protected void printGameState(int currentAttempt, int guessedInARow, String[] maskedWord, List<String> usedLetters) {
        int maxAttempts = 6;
        int remainedAttempts = maxAttempts - currentAttempt;
        String attemptWord = OutputText.ATTEMPT_V1;

        if (remainedAttempts > 1 && remainedAttempts < 5) {
            attemptWord = OutputText.ATTEMPT_V2;
        }
        if (remainedAttempts == 1) {
            attemptWord = OutputText.ATTEMPT_V3;
        }

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

    protected void printStartMessage() {
        System.out.println(OutputText.START_GAME_MSG);
    }

    protected void printEndGameMessage(int attempts, int guessedInARow, String secretWord, String[] maskedWord, List<String> usedLetters) {
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
}