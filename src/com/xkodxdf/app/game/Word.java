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

    private String secret;
    private String masked;
    private String definition;
    private List<String> words;
    private List<String> definitions;
    private int randomBound;
    private final int lengthForHint;
    private final String maskSymbol;
    private final Dictionary dictionary;


    protected Word(DictionaryFile initDictionary) {
        maskSymbol = "*";
        lengthForHint = 8;
        dictionary = new Dictionary(initDictionary);
        words = new ArrayList<>(dictionary.getWordBook().keySet());
        randomBound = words.size();
        definitions = new ArrayList<>(dictionary.getWordBook().values());
    }


    protected String getSecret() {
        return secret;
    }

    protected String getMasked() {
        return masked;
    }

    protected String getDefinition() {
        return definition;
    }


    public void setup() {
        if (randomBound == 0) {
            randomBound = words.size();
        }
        int index = ThreadLocalRandom.current().nextInt(randomBound);
        secret = words.get(index);
        setMasked();
        setDefinition();
        Collections.swap(words, index, randomBound - 1);
        Collections.swap(definitions, index, randomBound - 1);
        randomBound--;
    }

    private void setMasked() {
        masked = maskSymbol.repeat(secret.length());
        if (secret.length() >= lengthForHint) {
            masked = Utils.openRandomLetter(secret, masked.toCharArray());
        }
    }

    private void setDefinition() {
        definition = definitions.get(words.indexOf(secret));
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
