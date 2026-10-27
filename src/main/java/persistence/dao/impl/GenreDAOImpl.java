
package persistence.dao.impl;

import persistence.Connector;
import persistence.dao.GenreDAO;
import persistence.dto.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * MySQL implementation of GenreDAO.
 *
 * @author Niharika Madan
 */
public class GenreDAOImpl implements GenreDAO {

    private final Connector connector;

    /**
     * Creates a genre DAO using the supplied database connector.
     *
     * @param connector the database connector
     */
    public GenreDAOImpl(Connector connector) {
        this.connector = connector;
    }

    /**
     * Retrieves all genres ordered by name.
     *
     * @return a list of genres
     * @throws SQLException if a database error occurs
     */
    @Override
    public List<Genre> findAll() throws SQLException {
        List<Genre> genres = new ArrayList<>();
        String sql = "SELECT genre_id, genre_name FROM genres ORDER BY genre_name";

        Connection connection = connector.getConnection();

        if (connection == null) {
            throw new SQLException("Could not connect to the database.");
        }

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Genre genre = new Genre(
                        resultSet.getInt("genre_id"),
                        resultSet.getString("genre_name")
                );
                genres.add(genre);
            }
        } finally {
            connector.freeConnection();
        }

        return genres;
    }
}
