package repository;

import entities.Rating;
import entities.Song;

import java.util.List;

/**
 *  song rating operations.
 * @author Collins
 */
public interface RatingRepository {

    /**
     * Submits or updates a song rating.
     * @param rating rating details
     * @return true if successful
     */
    boolean rateSong(Rating rating);

    /**
     * Retrieves all ratings made by a user.
     * @param userId user ID
     * @return list of ratings
     */
    List<Rating> getUserRatings(int userId);

    /**
     * Retrieves a user's ratings with a specific score.
     * @param userId user ID
     * @param rating rating score
     * @return matching ratings
     */
    List<Rating> getUserRatingsByScore(int userId, int rating);

    /**
     * Retrieves the highest-rated songs.
     * @return list of highest-rated songs
     */
    List<Song> getHighestRatedSongs();
}