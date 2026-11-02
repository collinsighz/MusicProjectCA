package persistence;

import entities.Genre;
import java.util.List;

/**
 * Defines database operations for music genres.
 *
 * @author Niharika Madan
 */
public interface GenreDao {

    /**
     * Retrieves all genres from the database.
     *
     * @return a list of genres
     */
    List<Genre> getAllGenres();
}
