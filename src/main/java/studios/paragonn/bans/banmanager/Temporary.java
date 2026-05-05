package studios.paragonn.bans.banmanager;

public interface Temporary
{
    long getExpires();
    
    boolean hasExpired();
}
