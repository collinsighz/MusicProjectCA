package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnector implements Connector {

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/music_library";
    private String username = "root";
    private String password = "";

    private Connection connection;

    @Override
    public Connection getConnection() {

        try {
            Class.forName(driver);

            try {
                connection = DriverManager.getConnection(
                        url, username, password);

                return connection;

            } catch (SQLException e) {
                System.out.println("Exception: " + e.getMessage());
                System.out.println(
                        "Cannot establish a connection to " + url);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Exception: " + e.getMessage());
            System.out.println(
                    "No driver files found - please check dependencies.");
        }

        return null;
    }

    @Override
    public void freeConnection() {

        if (connection != null) {
            try {
                connection.close();
                connection = null;

            } catch (SQLException e) {
                System.out.println(
                        "An exception occurred when closing the database connection: "
                                + e.getMessage());
            }
        }
    }
}