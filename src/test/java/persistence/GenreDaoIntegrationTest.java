package persistence;

import entities.Genre;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenreDaoIntegrationTest {

    @Test
    void getAllGenresReturnsGenresFromDatabase() {
        MySqlConnector connector = new MySqlConnector();
        GenreDao genreDao = new GenreDaoImpl(connector);

        List<Genre> genres = genreDao.getAllGenres();

        assertNotNull(genres);
    }
}
