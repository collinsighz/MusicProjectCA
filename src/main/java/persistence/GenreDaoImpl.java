package persistence;

import entities.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * MySQL implementation of GenreDao.
 *
 * @author Niharika Madan
 */
public class GenreDaoImpl implements GenreDao {

    private final Connector connector;

    /**
     * Creates a genre DAO using the supplied database connector.
     *
     * @param connector the database connector
     */
    public GenreDaoImpl(Connector connector) {
        this.connector = connector;
    }

    /**
     * Retrieves all genres ordered by name.
     *
     * @return a list of genres
     */
    @Override
    public List<Genre> getAllGenres() {

        List<Genre> genres = new ArrayList<>();

        String sql = "SELECT genre_id, genre_name FROM genres ORDER BY genre_name";

        Connection connection = connector.getConnection();

        if (connection == null) {
            System.out.println("Could not connect to the database.");
            return genres;
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

        } catch (SQLException e) {

            System.out.println("Could not retrieve genres: " + e.getMessage());

        } finally {

            connector.freeConnection();
        }

        return genres;
    }
}
