package studios.paragonn.bans.banmanager;

import studios.paragonn.bans.Msg;
import studios.paragonn.bans.PBans;

public class IPBan extends Ban
{
    public IPBan(final String ip, final String reason, final String banner, final long created) {
        super(ip, reason, banner, created);
    }
    
    public String getKickMessage() {
        return Msg.get("disconnection.you-are-ipbanned", new String[] { "reason", "banner", "appeal-message" }, new String[] { this.getReason(), this.getBanner(), PBans.instance.getBanManager().getAppealMessage() });
    }
}
