package entities;

/**
 * Represents a song in the music library.
 * @author Collins
 */
public record Song(
        int songId,
        int artistId,
        Integer albumId,
        int genreId,
        String songTitle
) {
}