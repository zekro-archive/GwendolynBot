package util;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import static util.Statics.getTimeStamp;

/**
 * GwendolynBot
 *
 * Contributors for this class:
 *  - github.com/itsNaix
 *  - github.com/
 *
 * © DARK DEVS 2017
 */

public class MySQL {

    private static String username;
    private static String password;
    private static String database;
    private static String host;
    private static String port;
    private static Connection con;

    public static void checkMySQLFile() {
        File dir = new File(System.getProperty("user.dir") + "/settings/");
        File file = new File(dir.getAbsolutePath(), "mysql.cfg");

        if (!dir.exists()) dir.mkdirs();
        if (!file.exists()) {

            try {
                file.createNewFile();
                Properties properties = new Properties();
                OutputStream outputStream = null;

                try {
                    outputStream = new FileOutputStream(System.getProperty("user.dir") + "/settings/mysql.cfg");
                    properties.setProperty("username", "root");
                    properties.setProperty("password", "password");
                    properties.setProperty("database", "localhost");
                    properties.setProperty("host", "127.0.0.1");
                    properties.setProperty("port", "3306");
                    properties.store(outputStream, null);
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

    public static String getMySQLConf(String s) {

        Properties properties = new Properties();
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream(System.getProperty("user.dir") + "/settings/mysql.cfg");
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

    public static void getMySQLData() {

        MySQL.username = getMySQLConf("username");
        MySQL.password = getMySQLConf("password");
        MySQL.database = getMySQLConf("database");
        MySQL.host = getMySQLConf("host");
        MySQL.port = getMySQLConf("port");
    }

    public static void connect() {

        if(!isConnected()) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", username, password);
                System.out.println("[" + getTimeStamp() + "] [Info] [SQL] MySQL-Connection succeeded!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close() {
        if (isConnected()) {
            try {
                con.close();
                System.out.println("[" + getTimeStamp() + "] [Info] [SQL] MySQL-Connection was closed!");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void execute(String qry) {
        try {
            PreparedStatement ps = con.prepareStatement(qry);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getResult(String qry) {
        try {
            PreparedStatement ps = con.prepareStatement(qry);
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void checkTables() {
        if (isConnected()) {
            MySQL.execute("CREATE TABLE IF NOT EXISTS users_xp (id int NOT NULL AUTO_INCREMENT, user_id VARCHAR(100), xp int(100), PRIMARY KEY (id))");
        }
    }

    public static boolean isConnected() {
        return con != null;
    }

    public static Connection getConnection() {
        return con;
    }

}
