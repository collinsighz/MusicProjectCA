package persistence;

import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Using JDBC, implement a database operation for user accounts.
 *
 * @author Beni
 */
public class UserDaoImpl implements UserDao {

    private final Connector connector;

    /// @param connector Establishes connection to access the database
    public UserDaoImpl(Connector connector){
        this.connector = connector;
    }
}