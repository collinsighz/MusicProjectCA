package repository;

import entities.Album;
import java.util.List;
import java.util.Optional;

/**
 * Defines the operations available for retrieving albums.
 *
 * @author Niharika Madan
 */
public interface AlbumRepository {

    /**
     * Retrieves all albums belonging to a particular artist.
     *
     * @param artistId the artist ID
     * @return a list of albums by the artist
     */
    List<Album> getAlbumsByArtistId(int artistId);

    /**
     * Finds an album using its ID.
     *
     * @param albumId the album ID
     * @return the album if found, otherwise empty
     */
    Optional<Album> getAlbumById(int albumId);
}
