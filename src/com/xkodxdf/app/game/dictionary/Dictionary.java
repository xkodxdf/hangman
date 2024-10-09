package com.xkodxdf.app.game.dictionary;

import com.xkodxdf.app.Config;
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


    public Dictionary(String wordsFilePath) {
        setupWordBook(wordsFilePath);
    }


    public Map<String, String> getWordBook() {
        return wordBook;
    }


    public Dictionary setupWordBook(String wordsFilePath) {
        try (Scanner scn = new Scanner(Path.of(wordsFilePath))) {
            loadWords(scn);
        } catch (IOException e) {
            System.out.println(OutputText.FILE_LOCATION_PROBLEM + wordsFilePath
                    + OutputText.OR_INPUT_FILE_PATH + Config.RUS_FILE_PATH);
            changeFilePathOrExit();
        } catch (DictionaryIsEmptyException e) {
            System.out.println(wordsFilePath + e.getMessage() + Config.RUS_FILE_PATH);
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
        String answer;
        String inputFilePath = "1";
        String exit = "2";
        while (true) {
            System.out.println(OutputText.INPUT_FILE_PATH_OR_EXIT);
            answer = Utils.getInput();
            if (inputFilePath.equals(answer)) {
                System.out.print(OutputText.PATH_TO_FILE);
                setupWordBook(Utils.getInput());
                break;
            }
            if (exit.equals(answer)) {
                System.exit(0);
            }
        }
    }
}