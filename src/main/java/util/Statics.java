package util;

import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import static util.Settings.getSettings;

/**
 * GwendolynBot
 *
 * Contributors for this class:
 *  - github.com/zekrotja
 *
 * © DARK DEVS 2017
 */

/*
    TODO:
    Diese klasse soll so, wie sie momentan gestaltet ist, erstmal nur dazu dienen, Variablen zu setten, die
    später in eine Settings Datei gepackt werden (wie z.B. Prefix, Game, usw...)
    Also erstmal alles hier rein packen, auch wenn es später durch eine Settings Datei ersetzt wird.
    - zekro

    DONE :3
    - naix

 */

public class Statics {

    /*
        TODO:
        Bei Versionsänderung dies bitte auch im selben Zug es in die
        Readme Datei an folgender Stelle eintragen:
        03 | ![](https://img.shields.io/badge/latest-0.1.0--beta-orange.svg)
                                                     ^
                                                   hier ;)
        - zekro
    */

    public static final OnlineStatus STATUS = OnlineStatus.ONLINE;

    public static boolean DEBUG = false;

    public static Game getGame() {
        return Game.of("GwendolynBot | v." + getSettings("version"));
    }

    public static String getTimeStamp() {

        String timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
        return timestamp;

    }


}
