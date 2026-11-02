package repository;

import entities.Genre;
import org.junit.jupiter.api.Test;
import persistence.GenreDaoImpl;
import persistence.MySqlConnector;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Integration tests for GenreRepository.
 *
 * @author Niharika Madan
 */
class GenreRepositoryIntegrationTest {

    @Test
    void getAllGenresReturnsAList() {
        MySqlConnector connector = new MySqlConnector();
        GenreDaoImpl genreDao = new GenreDaoImpl(connector);
        GenreRepository genreRepository = new GenreRepositoryImpl(genreDao);

        List<Genre> genres = genreRepository.getAllGenres();

        assertNotNull(genres);
    }
}
