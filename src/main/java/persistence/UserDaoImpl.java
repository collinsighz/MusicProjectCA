package persistence;

import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implements database operations for user accounts using JDBC.
 *
 * @author Collins
 */
public class UserDaoImpl implements UserDao {

    private final Connector connector;

    /**
     * Constructs a UserDaoImpl using the supplied database connector.
     *
     * @param connector the connector used to access the database
     * @author collins
     */
    public UserDaoImpl(Connector connector) {
        this.connector = connector;
    }

    /**
     * Adds a user to the database.
     *
     * @param user the user to add
     * @return true if one row was inserted, otherwise false
     */
    @Override
    public boolean addUser(User user) {

        String sql = """
                INSERT INTO users
                (first_name, last_name, username, email, password_hash)
                VALUES (?, ?, ?, ?, ?)
                """;

        Connection connection = connector.getConnection();

        if (connection == null) {
            return false;
        }

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.firstName());
            statement.setString(2, user.lastName());
            statement.setString(3, user.username());
            statement.setString(4, user.email());
            statement.setString(5, user.passwordHash());

            return statement.executeUpdate() == 1;

        } catch (SQLException e) {
            System.out.println("Could not add user: " + e.getMessage());
            return false;

        } finally {
            connector.freeConnection();
        }
    }

    /**
     * Finds a user by their username.
     *
     * @param username the username to search for
     * @return the matching user, or null if no user is found
     * @author collins
     */
    @Override
    public User findUserByUsername(String username) {

        String sql = """
                SELECT user_id, first_name, last_name, username, email, password_hash
                FROM users
                WHERE username = ?
                """;

        Connection connection = connector.getConnection();

        if (connection == null) {
            return null;
        }

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    return new User(
                            resultSet.getInt("user_id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("username"),
                            resultSet.getString("email"),
                            resultSet.getString("password_hash")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Could not find user: " + e.getMessage());

        } finally {
            connector.freeConnection();
        }

        return null;
    }

    /**
     * Updates a user's password hash in the database.
     *
     * @param userId the ID of the user
     * @param passwordHash the new hashed password
     * @return true if one row was updated, otherwise false
     * @author collins
     */
    @Override
    public boolean updatePassword(int userId, String passwordHash) {

        String sql = """
                UPDATE users
                SET password_hash = ?
                WHERE user_id = ?
                """;

        Connection connection = connector.getConnection();

        if (connection == null) {
            return false;
        }

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, passwordHash);
            statement.setInt(2, userId);

            return statement.executeUpdate() == 1;

        } catch (SQLException e) {
            System.out.println("Could not update password: " + e.getMessage());
            return false;

        } finally {
            connector.freeConnection();
        }
    }
}