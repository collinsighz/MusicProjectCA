
package repository;

import entities.Album;
import org.junit.jupiter.api.Test;
import persistence.AlbumDaoImpl;
import persistence.MySqlConnector;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for AlbumRepository.
 *
 * @author Niharika Madan
 */
class AlbumRepositoryIntegrationTest {

    /**
     * Tests that albums belonging to an artist are retrieved successfully.
     */
    @Test
    void getAlbumsByArtistIdReturnsAList() {
        MySqlConnector connector = new MySqlConnector();
        AlbumDaoImpl albumDao = new AlbumDaoImpl(connector);
        AlbumRepository albumRepository = new AlbumRepositoryImpl(albumDao);

        List<Album> albums = albumRepository.getAlbumsByArtistId(1);

        assertNotNull(albums);
        assertEquals(1, albums.size());
        assertEquals("1989", albums.get(0).albumTitle());
        assertEquals(1, albums.get(0).artistId());
    }

    /**
     * Tests that an album can be retrieved using its ID.
     */
    @Test
    void getAlbumByIdReturnsAnOptional() {
        MySqlConnector connector = new MySqlConnector();
        AlbumDaoImpl albumDao = new AlbumDaoImpl(connector);
        AlbumRepository albumRepository = new AlbumRepositoryImpl(albumDao);

        Optional<Album> album = albumRepository.getAlbumById(1);

        assertTrue(album.isPresent());
        assertEquals("1989", album.get().albumTitle());
        assertEquals(1, album.get().artistId());
    }
}
