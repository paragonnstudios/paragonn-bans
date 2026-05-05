package studios.paragonn.bans.banmanager;

import studios.paragonn.bans.Msg;
import studios.paragonn.bans.PBans;

public class Ban extends Punishment
{
    public Ban(final String user, final String reason, final String banner, final long created) {
        super(user, reason, banner, created);
    }
    
    public String getKickMessage() {
        return Msg.get("disconnection.you-are-banned", new String[] { "reason", "banner", "appeal-message" }, new String[] { this.getReason(), this.getBanner(), PBans.instance.getBanManager().getAppealMessage() });
    }
}
