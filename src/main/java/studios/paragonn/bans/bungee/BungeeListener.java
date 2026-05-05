package studios.paragonn.bans.bungee;

import org.bukkit.plugin.Plugin;
import studios.paragonn.bans.banmanager.RangeBan;
import studios.paragonn.bans.banmanager.IPBan;
import studios.paragonn.bans.banmanager.Temporary;
import org.bukkit.ChatColor;
import studios.paragonn.bans.util.Formatter;
import studios.paragonn.bans.util.IPAddress;
import org.bukkit.Bukkit;
import java.io.DataInputStream;
import java.io.ByteArrayInputStream;
import org.bukkit.entity.Player;
import studios.paragonn.bans.PBans;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class BungeeListener implements PluginMessageListener
{
    private PBans plugin;
    
    public BungeeListener() {
        super();
        this.plugin = PBans.instance;
    }
    
    public void onPluginMessageReceived(final String channel, final Player player, final byte[] message) {
        try {
            final DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
            if (in.readUTF().equals("IP")) {
                final String ip = in.readUTF();
                PBans.instance.getBanManager().logIP(player.getName(), ip);
                Bukkit.getScheduler().runTaskLater((Plugin)this.plugin, (Runnable)new Runnable() {
                    public void run() {
                        final boolean whitelisted = PBans.instance.getBanManager().isWhitelisted(player.getName());
                        if (!whitelisted) {
                            final IPBan ipban = BungeeListener.this.plugin.getBanManager().getIPBan(ip);
                            if (ipban != null) {
                                player.kickPlayer(ipban.getKickMessage());
                                return;
                            }
                            final IPAddress address = new IPAddress(ip);
                            final RangeBan rb = BungeeListener.this.plugin.getBanManager().getBan(address);
                            if (rb != null) {
                                player.kickPlayer(rb.getKickMessage());
                                if (BungeeListener.this.plugin.getConfig().getBoolean("notify", true)) {
                                    final String msg = Formatter.secondary + player.getName() + Formatter.primary + " (" + ChatColor.RED + address + Formatter.primary + ")" + " tried to join, but is " + ((rb instanceof Temporary) ? "temp " : "") + "RangeBanned.";
                                    for (final Player p : Bukkit.getOnlinePlayers()) {
                                        if (p.hasPermission("maxbans.notify")) {
                                            p.sendMessage(msg);
                                        }
                                    }
                                }
                                return;
                            }
                            if (BungeeListener.this.plugin.getBanManager().getDNSBL() != null) {
                                BungeeListener.this.plugin.getBanManager().getDNSBL().handle(player, ip);
                            }
                        }
                    }
                }, 1L);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
