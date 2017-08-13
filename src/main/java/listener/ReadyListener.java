package listener;

import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.MySQL;
import java.util.stream.Collectors;

import static util.Settings.getSettings;
import static util.Statics.getTimeStamp;

/**
 * GwendolynBot
 *
 * Contributors for this class:
 *  - github.com/zekrotja
 *
 * © DARK DEVS 2017
 */

public class ReadyListener extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {

        System.out.println("\n-----------------------------------------\n" +
                           "GwendolynBot v. " + getSettings("version") + "\n" +
                           "Running on Guilds: \n" +
                           String.join("\n", event.getJDA().getGuilds().stream().map(g -> String.format("    - %s (%s)", g.getName(), g.getId())).collect(Collectors.toList())) +
                           "\n-----------------------------------------\n\n"
        );

        MySQL.checkMySQLFile();
        MySQL.getMySQLData();
        MySQL.connect();

        if (MySQL.isConnected()) {
            MySQL.checkTables();
        } else {
            System.out.println("[" + getTimeStamp() + "] [Error] [SQL] MySQL-Connection failed!");
        }

    }

}
