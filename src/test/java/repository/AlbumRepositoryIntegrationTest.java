package repository;

import entities.Album;
import org.junit.jupiter.api.Test;
import persistence.AlbumDaoImpl;
import persistence.MySqlConnector;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Integration tests for AlbumRepository.
 *
 * @author Niharika Madan
 */
class AlbumRepositoryIntegrationTest {

    @Test
    void getAlbumsByArtistIdReturnsAList() {
        MySqlConnector connector = new MySqlConnector();
        AlbumDaoImpl albumDao = new AlbumDaoImpl(connector);
        AlbumRepository albumRepository = new AlbumRepositoryImpl(albumDao);

        List<Album> albums = albumRepository.getAlbumsByArtistId(1);

        assertNotNull(albums);
    }

    @Test
    void getAlbumByIdReturnsAnOptional() {
        MySqlConnector connector = new MySqlConnector();
        AlbumDaoImpl albumDao = new AlbumDaoImpl(connector);
        AlbumRepository albumRepository = new AlbumRepositoryImpl(albumDao);

        Optional<Album> album = albumRepository.getAlbumById(1);

        assertNotNull(album);
    }
}
