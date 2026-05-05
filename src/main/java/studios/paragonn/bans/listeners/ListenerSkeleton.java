package studios.paragonn.bans.listeners;

import studios.paragonn.bans.PBans;
import org.bukkit.event.Listener;

public class ListenerSkeleton implements Listener
{
    protected PBans getPlugin() {
        return PBans.instance;
    }
}
