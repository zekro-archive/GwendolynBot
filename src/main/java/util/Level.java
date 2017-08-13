package util;

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


        return (int) Math.round(Statics.MIN_XP_LEVEL_1 * Math.pow( (double) 1 + Statics.ANSTIEG, level - 1));
    }


}
