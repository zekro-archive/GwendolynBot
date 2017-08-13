import commands.Ping;
import commands.Xp;
import core.CommandParser;
import listener.GuildMessageListener;
import listener.MessageListener;
import listener.ReadyListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import util.Level;
import util.Statics;

import javax.security.auth.login.LoginException;

/**
 * GwendolynBot
 *
 * Contributors for this class:
 *  - github.com/zekrotja
 *  - github.com/skillkiller
 *
 * © DARK DEVS 2017
 */

public class Main {

    private static JDABuilder builder;

    public static void main(String[] args) {

        builder = new JDABuilder(AccountType.BOT)
                .setToken(Statics.getToken())
                .setAutoReconnect(true)
                .setGame(Statics.getGame())
                .setStatus(Statics.STATUS);


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

}
