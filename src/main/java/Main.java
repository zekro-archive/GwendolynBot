import commands.Ping;
import commands.Xp;
import core.CommandParser;
import listener.GuildMessageListener;
import listener.MessageListener;
import listener.ReadyListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import util.Settings;
import util.Statics;

import javax.security.auth.login.LoginException;

import static util.Settings.getSettings;

/**
 * GwendolynBot
 *
 * Contributors for this class:
 *  - github.com/zekrotja
 *  - github.com/skillkiller
 *  - github.com/itsNaix
 *
 * © DARK DEVS 2017
 */

public class Main {

    private static JDABuilder builder;

    public static void main(String[] args) {

        Settings.checkSettingsFile();

        builder = new JDABuilder(AccountType.BOT)
                .setToken(getSettings("token"))
                .setAutoReconnect(true)
                .setGame(Statics.getGame())
                .setStatus(Statics.STATUS);


        initSettings();
        registerListeners();
        registerCommands();

        try {
            builder.buildBlocking();
        } catch (LoginException | InterruptedException | RateLimitedException e) {
            e.printStackTrace();
        }

    }

    private static void registerListeners() {
        builder
                .addEventListener(new ReadyListener())
                .addEventListener(new MessageListener())
                .addEventListener(new GuildMessageListener());
    }

    private static void registerCommands() {
        // Für den command einfach mal ein alias registriert um zu zeigen, wie man den overload benutz ^^
        CommandParser.register("ping", new String[] {"connection"}, new Ping());
        CommandParser.register("xp", new String[] {"level", "lvl"}, new Xp());
    }

    private static void initSettings() {
        if (getSettings("debug").equalsIgnoreCase("true")) {
            Statics.DEBUG = true;
        } else Statics.DEBUG = false;
    }

}
