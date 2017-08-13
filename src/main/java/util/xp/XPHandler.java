package util.xp;

import net.dv8tion.jda.core.entities.User;
import util.MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class XPHandler {

    public static boolean userExists(User user) {

        if (user != null) {
            ResultSet resultSet = MySQL.getResult("SELECT * FROM users_xp WHERE user_id = '" + user.getId() + "'");
            try {
                if (resultSet.next()) return true;
                else return false;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public static int getXP(User user) {

        try {
            if (userExists(user)) {

                ResultSet resultSet = MySQL.getResult("SELECT xp FROM users_xp WHERE user_id = '" + user.getId() + "'");
                if (resultSet.next()) return resultSet.getInt("xp");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return 0;
    }
    public static void setXP (User user) {

    }
    public static void addXP (User user, int value) {
        if (userExists(user)) {
            try {
                ResultSet resultSet = MySQL.getResult("SELECT xp FROM users_xp WHERE user_id = '" + user.getId() + "'");
                if (resultSet.next()) {
                    int current = resultSet.getInt("xp");
                    int updated = current + value;
                    PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("UPDATE users_xp SET xp=? WHERE user_id='" + user.getId() + "'");
                    preparedStatement.setInt(1, updated);
                    preparedStatement.executeUpdate();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void remXP (User user, int value) {
        if (userExists(user)) {
            try {
                ResultSet resultSet = MySQL.getResult("SELECT xp FROM users_xp WHERE user_id = '" + user.getId() + "'");
                if (resultSet.next()) {
                    int current = resultSet.getInt("xp");
                    int updated = current - value;
                    PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("UPDATE users_xp SET xp=? WHERE user_id='" + user.getId() + "'");
                    preparedStatement.setInt(1, updated);
                    preparedStatement.executeUpdate();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void  setMoney(User user, int value) {
        if (userExists(user)) {
            try {
                ResultSet resultSet = MySQL.getResult("SELECT xp FROM users_xp WHERE user_id='" + user.getId() + "'");
                if (resultSet.next()) {
                    PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("UPDATE users_xp SET xp=? WHERE user_id='" + user.getId() + "'");
                    preparedStatement.setInt(1, value);
                    preparedStatement.executeUpdate();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
