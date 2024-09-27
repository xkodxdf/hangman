package com.xkodxdf.app.display;

public enum HangmanImage {
    IMAGE_1("    +---+\n" +
            "    |   |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    ========="),
    IMAGE_2("    +---+\n" +
            "    |   |\n" +
            "    |   O\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    ========="),
    IMAGE_3("    +---+\n" +
            "    |   |\n" +
            "    |   O\n" +
            "    |   |\n" +
            "    |\n" +
            "    |\n" +
            "    ========="),
    IMAGE_4("    +---+\n" +
            "    |   |\n" +
            "    |   O\n" +
            "    |  /|\n" +
            "    |\n" +
            "    |\n" +
            "    ========="),
    IMAGE_5("    +---+\n" +
            "    |   |\n" +
            "    |   O\n" +
            "    |  /|\\\n" +
            "    |\n" +
            "    |\n" +
            "    ========="),
    IMAGE_6("    +---+\n" +
            "    |   |\n" +
            "    |   O\n" +
            "    |  /|\\\n" +
            "    |  /\n" +
            "    |\n" +
            "    ========="),
    IMAGE_7("    +---+\n" +
            "    |   |\n" +
            "    |   O\n" +
            "    |  /|\\\n" +
            "    |  / \\\n" +
            "    |\n" +
            "    =========");


    private final String HANGMAN_IMAGE;


    HangmanImage(String s) {
        this.HANGMAN_IMAGE = s;
    }


    @Override
    public String toString() {
        return HANGMAN_IMAGE;
    }
}
