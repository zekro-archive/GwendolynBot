package util;

import static util.Settings.getSettings;

/**
 * GwendolynBot
 *
 * Contributors for this class:
 * - github.com/skillkiller
 *
 * © DARK DEVS 2017
 */
public class Level {

    public static int getXPbyLevel(int level) {
        /*
        Erklärung:
        Prinzip des Zinseszins. Es wird immer ein bestimmter % Anteil auf die XP vom vorherigen Level gerechnet
        und das wird Hoch der Level genommen.

         */


        return (int) Math.round(Integer.parseInt(getSettings("xp_level_default")) * Math.pow( (double) 1 + Double.parseDouble("xp_level_rise") , level - 1));
    }


}
