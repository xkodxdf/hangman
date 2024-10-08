package com.xkodxdf.app.game;

import com.xkodxdf.app.game.display.HangmanImage;
import com.xkodxdf.app.util.Utils;

import java.util.LinkedHashSet;
import java.util.Set;

public class State {

    private String letter;
    private String secretWord;
    private String maskedWord;
    private String wordDefinition;
    private int currentAttempts;
    private int remainedAttempts;
    private final int maxAttempts;
    private boolean isAttemptsOver;
    private boolean isWordGuessed;
    private int wordsGuessedCounter;
    private boolean isRoundContinue;
    private boolean isGameContinue;
    private boolean isRusLang;
    private final Set<String> usedLetters;


    protected State() {
        maxAttempts = HangmanImage.values().length - 1;
        currentAttempts = 0;
        remainedAttempts = maxAttempts - currentAttempts;
        usedLetters = new LinkedHashSet<>();
        isGameContinue = true;
    }


    public String getSecretWord() {
        return secretWord;
    }

    protected void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    public String getMaskedWord() {
        return maskedWord;
    }

    protected void setMaskedWord(String maskedWord) {
        this.maskedWord = maskedWord;
    }

    public String getWordDefinition() {
        return wordDefinition;
    }

    protected void setWordDefinition(String wordDefinition) {
        this.wordDefinition = " - " + wordDefinition;
    }

    protected String getLetter() {
        return letter;
    }

    protected void setLetter(String letter) {
        this.letter = letter;
    }

    protected int getMaxAttempts() {
        return maxAttempts;
    }

    public int getCurrentAttempts() {
        return currentAttempts;
    }

    protected void changeAttemptCounters() {
        currentAttempts++;
        remainedAttempts--;
    }

    protected void resetAttemptCounters() {
        currentAttempts = 0;
        remainedAttempts = maxAttempts;
    }

    public int getRemainedAttempts() {
        return remainedAttempts;
    }

    public int getWordsGuessedCounter() {
        return wordsGuessedCounter;
    }

    protected void increaseWordsGuessedCounter() {
        wordsGuessedCounter++;
    }

    protected void resetWordsGuessedCounter() {
        wordsGuessedCounter = 0;
    }

    protected boolean isAttemptsOver() {
        return isAttemptsOver;
    }

    protected void setAttemptsOver(boolean attemptsOver) {
        isAttemptsOver = attemptsOver;
    }

    public boolean isWordGuessed() {
        return isWordGuessed;
    }

    protected void setWordGuessed(boolean wordGuessed) {
        isWordGuessed = wordGuessed;
    }

    protected boolean isGameContinue() {
        return isGameContinue;
    }

    protected void setIsGameContinue(boolean isContinue) {
        this.isGameContinue = isContinue;
    }

    protected boolean isRoundContinue() {
        return isRoundContinue;
    }

    protected void setRoundContinue(boolean roundContinue) {
        isRoundContinue = roundContinue;
    }

    protected void defineIsRusLang() {
        isRusLang = Utils.isCyrillic(secretWord);
    }

    public boolean isRusLang() {
        return isRusLang;
    }

    public Set<String> getUsedLetters() {
        return usedLetters;
    }

    protected void addToUsedLetters(String letter) {
        usedLetters.add(letter);
    }

    protected void clearUsedLetters() {
        usedLetters.clear();
    }
}
