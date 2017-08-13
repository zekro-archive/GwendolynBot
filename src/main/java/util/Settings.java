package util;

import java.io.*;
import java.util.Properties;

import static util.Statics.getTimeStamp;
import static util.Statics.DEBUG;

public class Settings {

    /*
    private static final File dir = new File(System.getProperty("user.dir") + "/settings/");
    private static final File file = new File(dir.getAbsolutePath(), "gwendolyn.cfg");

        TODO:
        Ich bin dafür, dass alle Dateien, die der Bot anlegt oder benutz im root path vom bot liegen,
        damit man noch optional in die files eingreifen kann und die nicht suchen muss.
        Können ja nochmal aufm discord drüber diskutieren ^^

        - zekro

    */

    private static final File dir = new File("settings/");
    private static final File file = new File(dir.getAbsolutePath(), "gwendolyn.cfg");

    public static void checkSettingsFile() {

        if (!dir.exists()) dir.mkdirs();
        if (!file.exists()) {

            if (DEBUG) System.out.println("[" + getTimeStamp() + "] [Debug] Creating gwendolyn.cfg...");

            try {
                file.createNewFile();
                Properties properties = new Properties();
                OutputStream outputStream = null;

                try {
                    outputStream = new FileOutputStream(file);
                    properties.setProperty("prefix", "g!");
                    properties.setProperty("version", "0.0");
                    properties.setProperty("debug", "false");
                    properties.setProperty("xp_level_default", "100");
                    properties.setProperty("xp_level_rise", "0.10");
                    properties.setProperty("token", "your_token");
                    properties.store(outputStream, null);
                    if (DEBUG) System.out.println("[" + getTimeStamp() + "] [Debug] Created gwendolyn.cfg successfully");
                } catch (IOException ex) {
                    ex.printStackTrace();
                } finally {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException ex) {
                            ex.getLocalizedMessage();
                        }
                    }
                }


            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }
    public static String getSettings(String s) {

        Properties properties = new Properties();
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream(file);
            properties.load(inputStream);
        } catch (IOException ex) {
            ex.getLocalizedMessage();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    ex.getLocalizedMessage();
                }
            }
        }

        return properties.getProperty(s);

    }

}
