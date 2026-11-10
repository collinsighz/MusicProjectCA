package entities;

/**
 * Represents an artist in the database
 * @param artistId
 * @param artistName
 * @Author Collins
 */

public record Artist(
        int artistId,
        String artistName
) {
}
