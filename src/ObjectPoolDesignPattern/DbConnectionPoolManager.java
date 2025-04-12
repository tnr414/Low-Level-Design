package ObjectPoolDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class DbConnectionPoolManager {
    private List<MySqlConnection> connectionsInUse = new ArrayList<>();
    private List<MySqlConnection> freeConnections = new ArrayList<>();
    private final int INITIAL_POOL_SIZE = 2;
    private final int MAX_POOL_SIZE = 3;
    private static int connectionId = 1;
    private static DbConnectionPoolManager dbConnectionPoolManagerInstance;

    private DbConnectionPoolManager() {
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            freeConnections.add(new MySqlConnection(connectionId++));
        }
    }

    public static DbConnectionPoolManager getInstance() {
        if (dbConnectionPoolManagerInstance == null) {
            synchronized (DbConnectionPoolManager.class) {
                if (dbConnectionPoolManagerInstance == null) {
                    dbConnectionPoolManagerInstance = new DbConnectionPoolManager();
                }
            }
        }

        return dbConnectionPoolManagerInstance;
    }


    public synchronized MySqlConnection getConnection() {
        if (freeConnections.isEmpty() && connectionsInUse.size() < MAX_POOL_SIZE) {
            MySqlConnection connection = new MySqlConnection(connectionId++);
            connectionsInUse.add(connection);
            System.out.println("New Connection: " +  connection.getConnectionId());
            return connection;
        } else if (freeConnections.isEmpty() && connectionsInUse.size() >= MAX_POOL_SIZE) {
            System.out.println("All connection in use");
            return null;
        }
        MySqlConnection freeConnection = freeConnections.removeLast();
        connectionsInUse.add(freeConnection);
        System.out.println("New Connection: " +  freeConnection.getConnectionId());
        return freeConnection;
    }

    public synchronized void releaseConnection(MySqlConnection connection) {
        if (connection != null) {
            connectionsInUse.remove(connection);
            freeConnections.add(connection);
            System.out.println("Connection with id " + connection.getConnectionId() + " released");
        }
    }
}
