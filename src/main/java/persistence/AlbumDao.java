package persistence;

import entities.Album;

import java.util.List;
import java.util.Optional;

/**
 * Defines database operations for albums.
 *
 * @author Niharika Madan
 */
public interface AlbumDao {

    /**
     * Retrieves albums belonging to a particular artist.
     *
     * @param artistId the artist ID
     * @return a list of albums by the artist
     */
    List<Album> getAlbumsByArtistId(int artistId);

    /**
     * Finds an album by its ID.
     *
     * @param albumId the album ID
     * @return the album if found, otherwise empty
     */
    Optional<Album> getAlbumById(int albumId);
}