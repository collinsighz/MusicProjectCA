
package persistence.dao;

import persistence.dto.Album;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Defines database operations for albums.
 *
 * @author Niharika Madan
 */
public interface AlbumDAO {

    /**
     * Retrieves albums belonging to a particular artist.
     *
     * @param artistId the artist ID
     * @return a list of albums by the artist
     * @throws SQLException if a database error occurs
     */
    List<Album> findByArtistId(int artistId) throws SQLException;

    /**
     * Finds an album by its ID.
     *
     * @param albumId the album ID
     * @return the album if found, otherwise empty
     * @throws SQLException if a database error occurs
     */
    Optional<Album> findById(int albumId) throws SQLException;
}
