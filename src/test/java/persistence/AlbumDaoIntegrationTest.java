package persistence;

import entities.Album;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AlbumDaoIntegrationTest {

    @Test
    void getAlbumsByArtistIdReturnsAlbums() {
        MySqlConnector connector = new MySqlConnector();
        AlbumDao albumDao = new AlbumDaoImpl(connector);

        List<Album> albums = albumDao.getAlbumsByArtistId(1);

        assertNotNull(albums);
    }

    @Test
    void getAlbumByIdReturnsOptional() {
        MySqlConnector connector = new MySqlConnector();
        AlbumDao albumDao = new AlbumDaoImpl(connector);

        Optional<Album> album = albumDao.getAlbumById(1);

        assertNotNull(album);
    }
}
