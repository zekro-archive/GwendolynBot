package commands;


import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

/**
 * GwendolynBot
 *
 * Contributors for this class:
 *  - github.com/zekrotja
 *
 * © DARK DEVS 2017
 */


public class Ping implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage(new EmbedBuilder().setColor(Color.cyan).setDescription(
                String.format("Pong!\n\n*Responded in `%s` milliseconds.*", event.getJDA().getPing())
        ).build()).queue();
    }

    @Override
    public String getHelp() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public int getPermission() {
        return 0;
    }
}
