package com.xkodxdf.app.game.display;

import com.xkodxdf.app.game.State;

public class Display {


    public void printGameScreen(State game) {
        printHangman(game.getCurrentAttempts());
        System.out.print(OutputText.ATTEMPTS_REMAINED + game.getRemainedAttempts());
        System.out.print(OutputText.GUESSED_WORDS_IN_A_ROW + game.getWordsGuessedCounter());
        System.out.println(game.isRusLang() ? OutputText.RU_LANG : OutputText.ENG_LANG);
        System.out.println(OutputText.USED_LETTERS + game.getUsedLetters());
        printMaskedWord(game.getMaskedWord());
    }

    private void printHangman(int currentAttempts) {
        System.out.println(HangmanImage.values()[currentAttempts]);
    }

    private void printMaskedWord(String maskedWord) {
        System.out.println(OutputText.HIDDEN_WORD + maskedWord);
    }

    public void printEndGameMsg(State game) {
        printGameScreen(game);
        if (game.isWordGuessed()) {
            System.out.print(OutputText.END_GAME_WIN_MSG);
        } else {
            System.out.print(OutputText.END_GAME_LOSS_MSG);
        }
        System.out.println(game.getSecretWord().toUpperCase()
                + game.getWordDefinition() + OutputText.SEPARATOR);
    }
}