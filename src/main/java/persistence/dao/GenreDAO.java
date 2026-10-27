
package persistence.dao;

import persistence.dto.Genre;
import java.sql.SQLException;
import java.util.List;

/**
 * Defines database operations for music genres.
 *
 * @author Niharika Madan
 */
public interface GenreDAO {

    /**
     * Retrieves all genres from the database.
     *
     * @return a list of genres
     * @throws SQLException if a database error occurs
     */
    List<Genre> findAll() throws SQLException;
}
