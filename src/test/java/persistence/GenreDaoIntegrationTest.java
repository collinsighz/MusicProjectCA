
package persistence;

import entities.Genre;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for GenreDao.
 *
 * @author Niharika Madan
 */
class GenreDaoIntegrationTest {

    /**
     * Tests that all genres are successfully retrieved from the database.
     */
    @Test
    void getAllGenresReturnsGenresFromDatabase() {
        MySqlConnector connector = new MySqlConnector();
        GenreDao genreDao = new GenreDaoImpl(connector);

        List<Genre> genres = genreDao.getAllGenres();

        assertNotNull(genres);
        assertEquals(6, genres.size());

        assertTrue(genres.stream()
                .anyMatch(genre -> genre.genreName().equals("Pop")));

        assertTrue(genres.stream()
                .anyMatch(genre -> genre.genreName().equals("Rock")));

        assertTrue(genres.stream()
                .anyMatch(genre -> genre.genreName().equals("Jazz")));
    }
}
