package ObjectPoolDesignPattern;

public class ObjectPoolPatternDemo {
    public static void main(String[] args) {
        DbConnectionPoolManager poolManager = DbConnectionPoolManager.getInstance();
        MySqlConnection connection1 = poolManager.getConnection();
        MySqlConnection connection2 = poolManager.getConnection();
        MySqlConnection connection3 = poolManager.getConnection();
        MySqlConnection connection4 = poolManager.getConnection();
        poolManager.releaseConnection(connection1);
        MySqlConnection connection5 = poolManager.getConnection();

    }
}
