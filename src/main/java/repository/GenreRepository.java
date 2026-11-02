package repository;

import entities.Genre;
import java.util.List;

/**
 * Defines the operations available for managing and retrieving genres.
 *
 * @author Niharika Madan
 */
public interface GenreRepository {

    /**
     * Retrieves all genres from the music library.
     *
     * @return a list of all genres
     */
    List<Genre> getAllGenres();
}