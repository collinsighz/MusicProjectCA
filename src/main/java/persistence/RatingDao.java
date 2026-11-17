package persistence;

import entities.Rating;
import entities.Song;

import java.util.List;

/**
 * Defines database operations for ratings.
 * @author Collins
 */
public interface RatingDao {

    /**
     * add and update song rating.
     * @param rating
     * @return true if successful
     */
    boolean saveRating(Rating rating);

    /**
     * Retrieves all ratings submitted by a user.
     * @param userId user ID
     * @return list of ratings
     * @author collins
     */
    List<Rating> findByUser(int userId);

    /**
     * Retrieves ratings submitted by a user with a specific score.
     * @param userId user ID
     * @param rating rating score
     * @return matching ratings
     * @author collins
     */
    List<Rating> findByUserAndRating(int userId, int rating);

    /**
     * Retrieves the highest-rated songs.
     * @return list of songs with the highest average rating
     * @author collins
     */
    List<Song> findHighestRatedSongs();
}