package listener;

import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.Statics;
import util.xp.XPHandler;

/**
 * GwendolynBot
 *
 * Contributors for this class:
 * - github.com/skillkiller
 *
 * © DARK DEVS 2017
 */
public class GuildMessageListener extends ListenerAdapter{

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String content = event.getMessage().getContent();
        int length = content.length();

        if(content.startsWith(Statics.PREFIX)) {
            //Commands werden schon gehandelt
            return;
        }

        // Get XP

        User user = event.getAuthor();
        XPHandler.addXP(user, calculateXP(length));
        
    }

    private int calculateXP(int length) {
        int xp = 0;
        if (length >=2) {
            xp = (int) Math.round(length/10) + 1;
            if(xp > 5) {
                xp =5;
            }
        }
        return xp;
    }
}
