package com.xkodxdf.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    private final List<String> wordList = new ArrayList<>();


    public List<String> getWordList() {
        return wordList;
    }


    void setWordList() throws IOException {
        String FILE_PATH = "./src/resources/data.txt";
        BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
        String word;
        while ((word = reader.readLine()) != null) {
            wordList.add(word);
        }
        reader.close();
    }
}