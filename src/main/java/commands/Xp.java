package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.Level;
import util.Messages;
import util.MySQL;
import util.xp.XPHandler;

/**
 * Created by Skillkiller on 13.08.2017.
 */
public class Xp implements Command {
    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        EmbedBuilder embedBuilder = new EmbedBuilder();


        //TODO Dringen Performanter machen durch Zwischenspeicherung mit Variablen
        String content = "**Deine XP**: " + XPHandler.getXP(event.getAuthor()) + "\n"
                + "**Aktuelles Level**: " + Level.getCurrentLevelByXp(XPHandler.getXP(event.getAuthor())) + "\n\n"
                + "Benötigt: " + Level.getXPbyLevel(Level.getCurrentLevelByXp(XPHandler.getXP(event.getAuthor()))+1);

        embedBuilder.addField("Dein Status", content, false);
        Messages.message(event.getTextChannel(), embedBuilder);
    }

    @Override
    public String getHelp() {
        return "Zeige dir deine Xp und dein Level an";
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
