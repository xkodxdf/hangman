package com.xkodxdf.app.game;

import com.xkodxdf.app.game.display.Display;

public class Main {

    public static void main(String[] args) {
        Game.init().start(new Display());
    }
}
