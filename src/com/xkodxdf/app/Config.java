package com.xkodxdf.app;

import java.io.File;

public final class Config {

    private static final String GENERAL = System.getProperty("user.dir")
            + File.separator + "src" + File.separator + "resources" + File.separator;

    public static final String RUS_FILE_PATH = GENERAL + "rusWords.txt";
    public static final String ENG_FILE_PATH = GENERAL + "engWords.txt";


    private Config() {
    }
}
