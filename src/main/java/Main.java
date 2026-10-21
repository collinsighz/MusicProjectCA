import persistence.MySqlConnector;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        MySqlConnector connector = new MySqlConnector();

        Connection connection = connector.getConnection();

        if (connection != null) {
            try {
                System.out.println("Connected successfully!");
                System.out.println("Database: " + connection.getCatalog());

            } catch (SQLException e) {
                System.out.println("Could not retrieve database name: "
                        + e.getMessage());

            } finally {
                connector.freeConnection();
                System.out.println("Connection closed.");
            }

        } else {
            System.out.println("Connection failed. Check the error above.");
        }
    }
}