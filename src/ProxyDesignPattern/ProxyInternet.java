package ProxyDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet {
    private final Internet internet = new RealInternet();
    private static final List<String> bannedSites = new ArrayList<>();

    static {
        bannedSites.add("banned.com");
        bannedSites.add("malware.com");
    }

    @Override
    public void connectTo(String serverHost) throws Exception {
        if (bannedSites.contains(serverHost)) {
            throw new Exception("Access Denied: " + serverHost);
        }

        internet.connectTo(serverHost);
    }
}
