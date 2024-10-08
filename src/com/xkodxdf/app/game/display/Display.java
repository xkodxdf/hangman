package com.xkodxdf.app.game.display;

import com.xkodxdf.app.game.State;

public class Display {

    private final State state;


    public Display(State state) {
        this.state = state;
    }


    public void printGameScreen() {
        printHangman();
        System.out.print(OutputText.ATTEMPTS_REMAINED + state.getRemainedAttempts());
        System.out.print(OutputText.GUESSED_WORDS_IN_A_ROW + state.getWordsGuessedCounter());
        System.out.println(state.isRusLang() ? OutputText.RU_LANG : OutputText.ENG_LANG);
        System.out.println(OutputText.USED_LETTERS + state.getUsedLetters());
        printMaskedWord();
    }

    private void printHangman() {
        System.out.println(HangmanImage.values()[state.getCurrentAttempts()]);
    }

    private void printMaskedWord() {
        System.out.println(OutputText.HIDDEN_WORD + state.getMaskedWord());
    }

    public void printEndGameMsg() {
        printGameScreen();
        if (state.isWordGuessed()) {
            System.out.print(OutputText.END_GAME_WIN_MSG);
        } else {
            System.out.print(OutputText.END_GAME_LOSS_MSG);
        }
        System.out.println(state.getSecretWord().toUpperCase()
                + state.getWordDefinition() + OutputText.SEPARATOR);
    }
}