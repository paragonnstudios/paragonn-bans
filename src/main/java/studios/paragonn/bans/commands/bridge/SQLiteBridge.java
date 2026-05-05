package studios.paragonn.bans.commands.bridge;

import java.sql.SQLException;
import studios.paragonn.bans.PBans;
import studios.paragonn.bans.database.Database;

public class SQLiteBridge implements Bridge
{
    private Database db;
    
    public SQLiteBridge(final Database db) {
        super();
        this.db = db;
    }
    
    public void export() throws SQLException {
        PBans.instance.getDB().copyTo(this.db);
    }
    
    public void load() throws SQLException {
        this.db.copyTo(PBans.instance.getDB());
    }
}
