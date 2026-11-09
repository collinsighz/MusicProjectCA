package repository;

import entities.Rating;
import entities.Song;

import java.util.List;

///  Operation of rating songs
/// @author Beni
public interface RatingRepository {

    /// @param rating Submit or update a song's rating
    /// @return true if operation works
    boolean rateSong(Rating rating);

    /// Retrieve every rating made by the user
    /// @param userId the ID assigned to a user
    /// @return true if successful
    List<Rating> getUserRating(int userId);

    /// Search and retrieve a user's rating by score
    /// @param UserId the ID assigned to a user
    /// @param rating the score rating
    /// @return true if match is found
    List<Rating> getUserRatingByScore(int UserId, int rating);

    List<Rating> getUserRatings(int userId);

    List<Rating> getUserRatingsByScore(int userId, int rating);

    /// Finds the highest-rated songs
    /// @return List of songs with the highest rating
    List<Song> getHighestRatedSongs();
}