package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * GwendolynBot
 *
 * Contributors for this class:
 *  - github.com/zekrotja
 *
 * © DARK DEVS 2017
 */


public interface Command {

    void action(String[] args, MessageReceivedEvent event);
    String getHelp();
    String getDescription();
    int getPermission();

}
