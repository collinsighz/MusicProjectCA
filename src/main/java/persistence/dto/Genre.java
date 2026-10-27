
package persistence.dto;

/**
 * Represents a genre in the music library.
 *
 * @param genreId the unique genre ID
 * @param genreName the name of the genre
 * @author Niharika Madan
 */
public record Genre(int genreId, String genreName) {
}
