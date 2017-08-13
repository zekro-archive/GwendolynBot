package listener;

import core.CommandParser;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.MySQL;
import util.Statics;
import util.xp.XPHandler;

/**
 * GwendolynBot
 *
 * Contributors for this class:
 *  - github.com/zekrotja
 *  - github.com/itsNaix
 *
 * © DARK DEVS 2017
 */


public class MessageListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        // Parse & Handle Command
        if (event.getMessage().getContent().startsWith(Statics.PREFIX) &&
                !event.getAuthor().equals(event.getJDA().getSelfUser()) &&
                !event.getTextChannel().getType().equals(ChannelType.PRIVATE)) {
            CommandParser.handleCommand(CommandParser.parse(event));
        }

        // Get XP

        User user = event.getAuthor();

        if (!XPHandler.userExists(user)) {
            MySQL.execute("INSERT INTO users_xp(id, user_id, xp) VALUES (NULL, '" + user.getId() + "', 1)");
        } else {
            XPHandler.addXP(user, 1);
        }

    }

}
