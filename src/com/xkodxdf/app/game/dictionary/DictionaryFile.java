package com.xkodxdf.app.game.dictionary;

import java.io.File;

public enum DictionaryFile {

    RUSSIAN_WORDS(FilePath.RUS_WORDS),

    RUSSIAN_WORDSV2(FilePath.TEST),

    ENGLISH_WORDS(FilePath.ENG_WORDS);


    DictionaryFile(String filePath) {
        PATH = filePath;
    }

    private final String PATH;

    public String getPath() {
        return PATH;
    }

    private static class FilePath {
        private static final String GENERAL = System.getProperty("user.dir")
                + File.separator + "src" + File.separator + "resources" + File.separator;

        public static final String RUS_WORDS = GENERAL + "rusWords.txt";
        public static final String TEST = GENERAL + "test.txt";
        public static final String ENG_WORDS = GENERAL + "engWords.txt";
    }
}
