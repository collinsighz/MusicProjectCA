
package persistence;

import entities.Album;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for AlbumDao.
 *
 * @author Niharika Madan
 */
class AlbumDaoIntegrationTest {

    /**
     * Tests that albums belonging to an artist are retrieved successfully.
     */
    @Test
    void getAlbumsByArtistIdReturnsAlbums() {
        MySqlConnector connector = new MySqlConnector();
        AlbumDao albumDao = new AlbumDaoImpl(connector);

        List<Album> albums = albumDao.getAlbumsByArtistId(1);

        assertNotNull(albums);
        assertEquals(1, albums.size());
        assertEquals("1989", albums.get(0).albumTitle());
        assertEquals(1, albums.get(0).artistId());
    }

    /**
     * Tests that an album can be retrieved using its ID.
     */
    @Test
    void getAlbumByIdReturnsOptional() {
        MySqlConnector connector = new MySqlConnector();
        AlbumDao albumDao = new AlbumDaoImpl(connector);

        Optional<Album> album = albumDao.getAlbumById(1);

        assertTrue(album.isPresent());
        assertEquals("1989", album.get().albumTitle());
        assertEquals(1, album.get().artistId());
    }
}
