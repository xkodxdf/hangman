package com.xkodxdf.app.game;

public enum Option {
    NEW_RU_GAME("1"), NEW_ENG_GAME("2"),
    NEW_ROUND("1"), SWITCH_LANGUAGE("2"),
    INPUT_FILE_PATH("1"),
    EXIT("3");

    Option(String value) {
        this.VALUE = value;
    }

    private final String VALUE;

    public String getValue() {
        return VALUE;
    }
}
