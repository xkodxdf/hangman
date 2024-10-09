package com.xkodxdf.app.game;

import com.xkodxdf.app.Config;
import com.xkodxdf.app.game.dictionary.Dictionary;
import com.xkodxdf.app.util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Word {

    private String secretWord;
    private String maskedWord;
    private String wordDefinition;
    private List<String> words;
    private List<String> definitions;
    private final Dictionary dictionary;
    private final String maskSymbol;
    private final int lengthForHint;


    protected Word(String initLanguage) {
        maskSymbol = "*";
        lengthForHint = 8;
        dictionary = new Dictionary(initLanguage);
        words = new ArrayList<>(dictionary.getWordBook().keySet());
        definitions = new ArrayList<>(dictionary.getWordBook().values());
    }


    protected String getSecretWord() {
        return secretWord;
    }

    protected String getMaskedWord() {
        return maskedWord;
    }

    protected String getWordDefinition() {
        return wordDefinition;
    }


    public void setup() {
        int index = ThreadLocalRandom.current().nextInt(words.size());
        secretWord = words.get(index);
        setMasked();
        setDefinition();
        words.remove(index);
        if (words.isEmpty()) {
            resetWordDefinitionLists(dictionary.getWordBook());
        }
    }

    private void setMasked() {
        maskedWord = maskSymbol.repeat(secretWord.length());
        if (secretWord.length() >= lengthForHint) {
            maskedWord = Utils.openRandomLetter(secretWord, maskedWord.toCharArray());
        }
    }

    private void setDefinition() {
        wordDefinition = definitions.get(words.indexOf(secretWord));
        definitions.remove(wordDefinition);
    }

    private void resetWordDefinitionLists(Map<String, String> wordBook) {
        words = new ArrayList<>(wordBook.keySet());
        definitions = new ArrayList<>(wordBook.values());
    }

    protected void switchLanguage() {
        if (Utils.isCyrillic(words.get(0))) {
            resetWordDefinitionLists(dictionary.setupWordBook(Config.ENG_FILE_PATH).getWordBook());
        } else {
            resetWordDefinitionLists(dictionary.setupWordBook(Config.RUS_FILE_PATH).getWordBook());
        }
    }
}
