package com.xkodxdf.app.game;

import com.xkodxdf.app.game.display.OutputText;
import com.xkodxdf.app.util.Utils;

import java.util.Objects;

public class Logic {

    private final State state;
    private final Word word;


    protected Logic(State state, Word word) {
        this.state = state;
        this.word = word;
        statSetup();
    }

    public void statSetup() {
        word.setup();
        state.setSecretWord(word.getSecretWord());
        state.setMaskedWord(word.getMaskedWord());
        state.setWordDefinition(word.getWordDefinition());
        state.resetAttemptCounters();
        state.setIsGameContinue(true);
        state.clearUsedLetters();
        state.defineIsRusLang();
        checkRoundEnd();
    }

    protected void getLetterFromUser() {
        String letter;
        do {
            System.out.print(OutputText.INPUT_LETTER);
            letter = Utils.getInput();
            if (state.isRusLang() && Utils.validateRusLetterInput(letter)) {
                break;
            }
            if (!state.isRusLang() && Utils.validateEngLetterInput(letter)) {
                break;
            }
            System.out.print(OutputText.INVALID_INPUT);
        } while (true);
        state.setLetter(letter.toLowerCase());
        changeAttemptCounters();
        revealGuessedLetter();
        state.addToUsedLetters(letter.toUpperCase());
    }

    protected void revealGuessedLetter() {
        char charLetter = state.getLetter().charAt(0);
        String secretWord = state.getSecretWord();
        char[] maskedArr = state.getMaskedWord().toCharArray();
        for (int i = 0; i < maskedArr.length; i++) {
            if (secretWord.charAt(i) == charLetter) {
                maskedArr[i] = charLetter;
            }
        }
        state.setMaskedWord(Utils.arrToString(maskedArr));
    }

    protected void changeAttemptCounters() {
        if (state.getSecretWord().contains(state.getLetter())
                || state.getUsedLetters().contains(state.getLetter().toUpperCase())) {
            return;
        }
        state.changeAttemptCounters();
    }

    private void checkWin() {
        String secretWord = state.getSecretWord();
        String maskedWord = state.getMaskedWord();
        state.setWordGuessed(Objects.equals(secretWord, maskedWord));
    }

    private void checkLoss() {
        state.setAttemptsOver(state.getCurrentAttempts() >= state.getMaxAttempts());
    }

    protected void checkRoundEnd() {
        checkWin();
        checkLoss();
        state.setRoundContinue(!(state.isWordGuessed() || state.isAttemptsOver()));
        changeGuessedCounter();
    }

    protected void changeGuessedCounter() {
        if (state.isWordGuessed()) {
            state.increaseWordsGuessedCounter();
        }
        if (state.isAttemptsOver()) {
            state.resetWordsGuessedCounter();
        }
    }

    protected void askForContinue() {
        System.out.println(OutputText.CONTINUE_GAME_CHOICE);
        String answer;
        String newGame = "1";
        String changeLang = "2";
        String endGame = "3";

        do {
            answer = Utils.getInput();
            if (answer.equals(newGame) || answer.equals(changeLang)) {
                state.setIsGameContinue(true);
                if (answer.equals(changeLang)) {
                    word.switchLanguage();
                }
                statSetup();
                break;
            }
            if (answer.equals(endGame)) {
                state.setIsGameContinue(false);
                break;
            }
            System.out.println(OutputText.INVALID_NUM_INPUT);
        } while (true);
    }
}
