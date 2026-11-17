package entities;

import java.time.LocalDateTime;

/**
 * Represents a user's rating of a song.
 * @author Collins
 */
public record Rating(
        int userId,
        int songId,
        int rating,
        LocalDateTime ratedAt,
        LocalDateTime updatedAt
) {
}