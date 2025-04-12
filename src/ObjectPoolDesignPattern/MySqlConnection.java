package ObjectPoolDesignPattern;

public class MySqlConnection {
    private final int connectionId;

    public MySqlConnection(int connectionId) {
        this.connectionId = connectionId;
    }

    public int getConnectionId() {
        return connectionId;
    }
}
