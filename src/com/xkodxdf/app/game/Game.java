package com.xkodxdf.app.game;

import com.xkodxdf.app.display.OutputText;
import com.xkodxdf.app.util.Utils;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private final Scanner scn;
    private int attempts;
    private int guessedInARow;
    private final List<String> usedLetters;


    public Game(Scanner scn) {
        this.scn = scn;
        attempts = 0;
        guessedInARow = 0;
        usedLetters = new ArrayList<>();
    }


    public int getAttempts() {
        return attempts;
    }

    public int getGuessedInARow() {
        return guessedInARow;
    }

    protected List<String> getUsedLetters() {
        return usedLetters;
    }


    protected void resetAttempts() {
        this.attempts = 0;
    }

    protected String chooseSecretWord(List<String> wordList) {
        int randomPosition = ThreadLocalRandom.current().nextInt(wordList.size());

        return wordList.get(randomPosition);
    }

    protected String[] getMaskedWord(String word) {
        String mask_symbol = "*";
        String[] arr = new String[word.length()];
        Arrays.fill(arr, mask_symbol);
        if (arr.length > 7) {
            int randomCell = ThreadLocalRandom.current().nextInt(arr.length);
            arr[randomCell] = String.valueOf(word.charAt(randomCell));
        }

        return arr;
    }

    protected String getLetterFromUser() {
        String input;
        do {
            System.out.print(OutputText.INPUT_LETTER);
            input = Utils.getInput(scn);
            if (Utils.validateRusLetterInput(input)) {
                break;
            }
            System.out.print(OutputText.INVALID_LETTER_INPUT);
        } while (true);

        return input.toLowerCase();
    }

    protected void saveUsedLetters(String letter) {
        if (!usedLetters.contains(letter.toUpperCase())) {
            usedLetters.add(letter.toUpperCase());
        }
    }

    protected void clearUsedLettersList() {
        usedLetters.clear();
    }

    protected void changeAttemptCounter(String word, String letter, List<String> usedLetters) {
        if (word.contains(letter) || usedLetters.contains(letter.toUpperCase())) {
            return;
        }
        attempts++;
    }

    protected void changeGuessedInARowCounter(boolean isGuessed) {
        guessedInARow = isGuessed ? (guessedInARow + 1) : 0;
    }

    protected String[] revealGuessedLetter(String[] maskedWord, String word, String letter) {
        for (int i = 0; i < word.length(); i++) {
            if (String.valueOf(word.charAt(i)).equalsIgnoreCase(letter)) {
                maskedWord[i] = String.valueOf(word.charAt(i));
            }
        }

        return maskedWord;
    }

    protected boolean checkWinLoss(boolean isWordGuessed, int attempts) {
        return (isWordGuessed || (attempts >= 6));
    }

    protected boolean continueGame() {
        System.out.println(OutputText.CONTINUE_GAME_CHOICE);
        String answer;
        String newGame = "1";
        String endGame = "2";
        do {
            answer = Utils.getInput(scn);
            if (answer.equals(newGame)) {
                return true;
            }
            if (answer.equals(endGame)) {
                return false;
            }
            System.out.println(OutputText.INVALID_NUM_INPUT);
        } while (true);
    }

    protected boolean isMaskedWordEqualsSecret(String[] masked, String secret) {
        String maskedWord = Utils.arrToString(masked);

        return maskedWord.equals(secret);
    }
}
