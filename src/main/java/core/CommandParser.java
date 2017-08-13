package core;

import commands.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.Messages;
import util.Statics;

import java.util.Arrays;
import java.util.HashMap;

import static util.Settings.getSettings;

/**
 * GwendolynBot
 *
 * Contributors for this class:
 *  - github.com/zekrotja
 *
 * © DARK DEVS 2017
 */


public class CommandParser {

    public static HashMap<String, Command> commands = new HashMap<>();

    public static class CommandContainer {

        public String invoke;
        public String[] args;
        public MessageReceivedEvent event;

        public CommandContainer(String invoke, String[] args, MessageReceivedEvent event) {
            this.invoke = invoke;
            this.args = args;
            this.event = event;
        }

    }

    public static CommandContainer parse(MessageReceivedEvent event) {

        String content = event.getMessage().getContent();
        String invoke = content.split(" ")[0].substring(getSettings("prefix").length());

        String[] args = new String[content.split(" ").length - 1];
        args = Arrays.asList(content.split(" ")).subList(1, content.split(" ").length).toArray(args);

        return new CommandContainer(invoke, args, event);
    }

    public static void handleCommand(CommandContainer cmd) {

        if (commands.containsKey(cmd.invoke)) {
            commands.get(cmd.invoke).action(cmd.args, cmd.event);
        } else {
            Messages.error(cmd.event.getTextChannel(), String.format("This bot has no command `%s%s`.", getSettings("prefix"), cmd.invoke));
        }
    }

    public static  void register(String invoke, Command command) {
        commands.put(invoke, command);
    }

    public static  void register(String invoke, String[] aliases, Command command) {
        commands.put(invoke, command);
        for ( String s : aliases) {
            commands.put(s, command);
        }
    }

}
