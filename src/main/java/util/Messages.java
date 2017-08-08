package util;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;

import java.awt.*;

/**
 * GwendolynBot
 *
 * Contributors for this class:
 *  - github.com/zekrotja
 *
 * © DARK DEVS 2017
 */

public class Messages {

    public static Message error(TextChannel channel, String content) {
        return channel.sendMessage(new EmbedBuilder().setDescription(content).setColor(Color.red).build()).complete();
    }

    public static Message error(TextChannel channel, String content, String title) {
        return channel.sendMessage(new EmbedBuilder().setDescription(content).setColor(Color.red).setTitle(title).build()).complete();
    }

    public static Message message(TextChannel channel, String content) {
        return channel.sendMessage(content).complete();
    }

    public static Message message(TextChannel channel, EmbedBuilder embedBuilder) {
        return channel.sendMessage(embedBuilder.build()).complete();
    }

}
