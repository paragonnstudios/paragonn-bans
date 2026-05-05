package studios.paragonn.bans.commands;

import java.text.ParseException;
import studios.paragonn.bans.PBans;
import studios.paragonn.bans.util.Util;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class ImmuneCommand extends CmdSkeleton
{
    public ImmuneCommand() {
        super("immune", "maxbans.immune");
    }
    
    public boolean run(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length < 2) {
            sender.sendMessage(ChatColor.RED + "Usage: /immune <name> <true|false>");
            return true;
        }
        if (sender instanceof Player) {
            final Player p = (Player)sender;
            if (!p.hasPermission("PBans.immune") && !p.isOp() && !p.hasPermission("PBans.*")) {
                sender.sendMessage(ChatColor.RED + "You do not have permission to use that command!");
                return true;
            }
        }
        try {
            final boolean immune = Util.parseBoolean(args[1]);
            final String user = PBans.instance.getBanManager().match(args[0]);
            if (this.plugin.getBanManager().setImmunity(user, immune)) {
                sender.sendMessage(ChatColor.GREEN + "Success!");
            }
            else {
                sender.sendMessage(ChatColor.RED + "Failure - Nothing has changed.");
            }
        }
        catch (ParseException e) {
            sender.sendMessage(ChatColor.RED + "Unrecognised state " + args[1]);
        }
        return true;
    }
}
