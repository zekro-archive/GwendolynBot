package util;

import java.io.*;
import java.util.Properties;

import static util.Statics.getTimeStamp;
import static util.Statics.DEBUG;

public class Settings {

    public static void checkSettingsFile() {
        File dir = new File(System.getProperty("user.dir") + "/settings/");
        File file = new File(dir.getAbsolutePath(), "gwendolyn.cfg");

        if (!dir.exists()) dir.mkdirs();
        if (!file.exists()) {

            if (DEBUG) System.out.println("[" + getTimeStamp() + "] [Debug] Creating gwendolyn.cfg...");

            try {
                file.createNewFile();
                Properties properties = new Properties();
                OutputStream outputStream = null;

                try {
                    outputStream = new FileOutputStream(System.getProperty("user.dir") + "/settings/gwendolyn.cfg");
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
            inputStream = new FileInputStream(System.getProperty("user.dir") + "/settings/gwendolyn.cfg");
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
