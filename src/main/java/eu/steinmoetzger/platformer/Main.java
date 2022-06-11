/*
Copyright © Michael Steinmoetzger (ShortPing) 2015 - 2022

Alle Rechte sind für dieses Projekt verbehalten, sofern es nicht
anders in einer Lizenzdatei angegeben ist.

All rights are reserved for this project, unless otherwise
stated in a license file.
*/
package eu.steinmoetzger.platformer;

import eu.steinmoetzger.platformer.game.Game;

public class Main {


    public static Game INSTANCE;

    public static void main(String[] args) {
        Game game = new Game();
        INSTANCE = game;
        game.createWindow();

    }
}
