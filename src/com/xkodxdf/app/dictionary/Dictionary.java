package com.xkodxdf.app.dictionary;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Dictionary {

    private final Map<String, String> dictionary;


    public Dictionary() throws IOException {
        dictionary = new HashMap<>();
        setDictionary();
    }


    private void setDictionary() throws IOException {
        final String FILE_PATH = "./src/resources/rusWords.txt";
        final File file = new File(FILE_PATH);
        Scanner scn = new Scanner(file);
        String line;
        String[] splittedLine;
        while (scn.hasNext()) {
            line = scn.nextLine().trim().toLowerCase();
            if (line.contains(":")) {
                splittedLine = line.split(":");
                dictionary.put(splittedLine[0], splittedLine[1]);
            }
        }
        scn.close();
    }


    public List<String> getWordList() {
        return new ArrayList<>(dictionary.keySet());
    }

    public String getWordDefinition(String word) {
        return dictionary.get(word);
    }
}