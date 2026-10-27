
package persistence.dto;

import java.sql.Date;

/**
 * Represents an album in the music library.
 *
 * @param albumId the unique album ID
 * @param artistId the ID of the artist
 * @param albumTitle the album title
 * @param releaseDate the album release date
 * @param description the album description
 * @author Niharika Madan
 */
public record Album(
        int albumId,
        int artistId,
        String albumTitle,
        Date releaseDate,
        String description
) {
}
