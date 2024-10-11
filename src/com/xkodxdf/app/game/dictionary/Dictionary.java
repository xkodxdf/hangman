package com.xkodxdf.app.game.dictionary;

import com.xkodxdf.app.game.Option;
import com.xkodxdf.app.game.display.OutputText;
import com.xkodxdf.app.game.exception.DictionaryIsEmptyException;
import com.xkodxdf.app.util.Utils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

    private final Map<String, String> wordBook = new HashMap<>();


    public Dictionary(DictionaryFile initDictionary) {
        setupWordBook(initDictionary.getPath());
    }


    public Map<String, String> getWordBook() {
        return wordBook;
    }


    public Dictionary setupWordBook(String filePath) {
        try (Scanner scn = new Scanner(Path.of(filePath))) {
            loadWords(scn);
        } catch (IOException e) {
            System.out.println(OutputText.FILE_LOCATION_PROBLEM + filePath
                    + OutputText.OR_INPUT_FILE_PATH + DictionaryFile.RUSSIAN_WORDS.getPath());
            changeFilePathOrExit();
        } catch (DictionaryIsEmptyException e) {
            System.out.println(filePath + e.getMessage() + DictionaryFile.RUSSIAN_WORDS.getPath());
            changeFilePathOrExit();
        }

        return this;
    }

    private void loadWords(Scanner scn) throws DictionaryIsEmptyException {
        wordBook.clear();
        String line;
        String[] splitLine;
        while (scn.hasNext()) {
            line = scn.nextLine().toLowerCase();
            splitLine = line.split(":", 2);
            if (splitLine.length == 2) {
                wordBook.put(splitLine[0].trim(), splitLine[1].trim());
            }
        }
        if (wordBook.isEmpty()) {
            throw new DictionaryIsEmptyException(OutputText.FILE_CONTENT_PROBLEM);
        }
    }

    private void changeFilePathOrExit() {
        Option option;
        option = Utils.getOption(OutputText.INPUT_FILE_PATH_OR_EXIT, "",
                Option.INPUT_FILE_PATH, Option.EXIT);
        switch (option) {
            case INPUT_FILE_PATH:
                System.out.println(OutputText.PATH_TO_FILE);
                setupWordBook(Utils.getInput());
                break;
            case EXIT:
                System.exit(0);
        }
    }
}