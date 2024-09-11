package com.xkodxdf.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dictionary {

    private final String FILE_PATH = "src/resources/data.txt";
    private final ArrayList<String> wordList = new ArrayList<>();


    public ArrayList<String> getWordList() {
        return wordList;
    }

    void setWordList() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
        String word;
        while ((word = reader.readLine()) != null) {
            wordList.add(word);
        }
        reader.close();
    }
}