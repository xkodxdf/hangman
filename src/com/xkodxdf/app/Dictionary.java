package com.xkodxdf.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Dictionary {

    private final List<String> wordList = new ArrayList<>();


    public List<String> getWordList() {
        return wordList;
    }


    protected void setWordList() throws IOException {
        final String FILE_PATH = "./src/resources/data.txt";
        Stream<String> fileStream = Files.lines(Paths.get(FILE_PATH));
        fileStream.forEach(i -> {
            if (!i.isEmpty() && !i.trim().contains(" ")) {
                wordList.add(i.trim());
            }
        });
        fileStream.close();
    }
}