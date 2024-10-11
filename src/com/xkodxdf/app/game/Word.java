package com.xkodxdf.app.game;

import com.xkodxdf.app.game.dictionary.Dictionary;
import com.xkodxdf.app.game.dictionary.DictionaryFile;
import com.xkodxdf.app.util.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Word {

    private String secretWord;
    private String maskedWord;
    private String wordDefinition;
    private List<String> words;
    private List<String> definitions;
    private int randomBound;
    private final Dictionary dictionary;
    private final String maskSymbol;
    private final int lengthForHint;


    protected Word(DictionaryFile startDictionary) {
        maskSymbol = "*";
        lengthForHint = 8;
        dictionary = new Dictionary(startDictionary);
        words = new ArrayList<>(dictionary.getWordBook().keySet());
        definitions = new ArrayList<>(dictionary.getWordBook().values());
        randomBound = words.size();
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
        if (randomBound == 0) {
            randomBound = words.size();
        }
        int index = ThreadLocalRandom.current().nextInt(randomBound);
        secretWord = words.get(index);
        setMasked();
        setDefinition();
        Collections.swap(words, index, randomBound - 1);
        Collections.swap(definitions, index, randomBound - 1);
        randomBound--;
    }

    private void setMasked() {
        maskedWord = maskSymbol.repeat(secretWord.length());
        if (secretWord.length() >= lengthForHint) {
            maskedWord = Utils.openRandomLetter(secretWord, maskedWord.toCharArray());
        }
    }

    private void setDefinition() {
        wordDefinition = definitions.get(words.indexOf(secretWord));
    }

    private void resetWordDefinitionLists(Map<String, String> wordBook) {
        words = new ArrayList<>(wordBook.keySet());
        definitions = new ArrayList<>(wordBook.values());
        randomBound = words.size();
    }

    protected void switchLanguage() {
        if (Utils.isCyrillic(words.get(0))) {
            resetWordDefinitionLists(dictionary.setupWordBook(DictionaryFile.ENGLISH_WORDS.getPath()).getWordBook());
        } else {
            resetWordDefinitionLists(dictionary.setupWordBook(DictionaryFile.RUSSIAN_WORDS.getPath()).getWordBook());
        }
    }
}
