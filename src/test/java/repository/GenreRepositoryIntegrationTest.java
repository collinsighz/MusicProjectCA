
package repository;

import entities.Genre;
import org.junit.jupiter.api.Test;
import persistence.GenreDaoImpl;
import persistence.MySqlConnector;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for GenreRepository.
 *
 * @author Niharika Madan
 */
class GenreRepositoryIntegrationTest {

    /**
     * Tests that the repository retrieves all genres successfully.
     */
    @Test
    void getAllGenresReturnsAList() {
        MySqlConnector connector = new MySqlConnector();
        GenreDaoImpl genreDao = new GenreDaoImpl(connector);
        GenreRepository genreRepository = new GenreRepositoryImpl(genreDao);

        List<Genre> genres = genreRepository.getAllGenres();

        assertNotNull(genres);
        assertEquals(6, genres.size());

        assertTrue(genres.stream()
                .anyMatch(genre -> genre.genreName().equals("Pop")));
    }
}
