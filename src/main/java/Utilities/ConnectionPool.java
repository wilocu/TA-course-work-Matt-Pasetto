package Utilities;

import exeptions.NotConnectedExeption;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionPool {
    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class.getName());

    private static ConnectionPool pool;
    private final List<Connection> connectionPool = new ArrayList<>(5);

    private ConnectionPool() {
        Properties props = new Properties();
        FileInputStream in = null;
        try {
            in = new FileInputStream("src/main/resources/db.properties");
            props.load(in);
            in.close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage() + ", could not read db properties file");
        }

        try {
            String driver = props.getProperty("jdbc.driver");
            if (driver != null) {
                Class.forName(driver) ;
            }
        } catch (ClassNotFoundException e) {
            LOGGER.error(e.getMessage() + ", could not load driver");
        }

        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        for (int i = 0; i < 5; i++) {
            try {
                connectionPool.add(DriverManager.getConnection(url, username, password));
            } catch (SQLException e) {
                LOGGER.error(e.getMessage() + "could not add connection to pool");
            }
        }
    }

    public static ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

    public synchronized Connection getConnection() {
        try {
            if (connectionPool.isEmpty())
                throw new NotConnectedExeption("No connections available");
            return connectionPool.remove(connectionPool.size() - 1);
        } catch (NotConnectedExeption e) {
            LOGGER.warn(e.getMessage());
            try {
                connectionPool.add(DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "testuser", "ajdhteio")); //TODO fix
            } catch (SQLException s) {
                LOGGER.error(s.getMessage());
            }
        }
        return connectionPool.remove(connectionPool.size() - 1);
    }

    public synchronized void returnConnection(Connection connection) {
        connectionPool.add(connection);
    }
}
