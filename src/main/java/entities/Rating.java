package entities;

import java.time.LocalDateTime;

/// Represents a user giving a song a rating
public record Rating(
        int userId,
        int songId,
        int rating,
        LocalDateTime ratedAt,
        LocalDateTime updatedAt
){
}