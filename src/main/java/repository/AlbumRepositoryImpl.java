package repository;

import entities.Album;
import persistence.AlbumDao;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of AlbumRepository using AlbumDao.
 *
 * @author Niharika Madan
 */
public class AlbumRepositoryImpl implements AlbumRepository {

    private final AlbumDao albumDao;

    /**
     * Creates an album repository using the supplied DAO.
     *
     * @param albumDao the album data access object
     */
    public AlbumRepositoryImpl(AlbumDao albumDao) {
        this.albumDao = albumDao;
    }

    /**
     * Retrieves all albums belonging to a particular artist.
     *
     * @param artistId the artist ID
     * @return a list of albums by the artist
     */
    @Override
    public List<Album> getAlbumsByArtistId(int artistId) {
        return albumDao.getAlbumsByArtistId(artistId);
    }

    /**
     * Finds an album using its ID.
     *
     * @param albumId the album ID
     * @return the album if found, otherwise empty
     */
    @Override
    public Optional<Album> getAlbumById(int albumId) {
        return albumDao.getAlbumById(albumId);
    }
}
