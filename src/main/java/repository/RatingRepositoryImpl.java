package repository;

import entities.Rating;
import entities.Song;
import persistence.RatingDao;

import java.util.List;

/**
 * Implements song rating operations.
 * @author Collins
 */
public class RatingRepositoryImpl implements RatingRepository {

    private final RatingDao ratingDao;

    /**
     * Creates a RatingRepositoryImpl.
     * @param ratingDao rating DAO
     */
    public RatingRepositoryImpl(RatingDao ratingDao) {
        this.ratingDao = ratingDao;
    }

    /**
     * Submits or updates a song rating.
     * @param rating rating details
     * @return true if successful
     */
    @Override
    public boolean rateSong(Rating rating) {

        if (rating == null || rating.rating() < 1 || rating.rating() > 5) {
            return false;
        }

        return ratingDao.saveRating(rating);
    }

    /**
     * Retrieves all ratings made by a user.
     * @param userId user ID
     * @return list of ratings
     */
    @Override
    public List<Rating> getUserRatings(int userId) {

        if (userId <= 0) {
            return List.of();
        }

        return ratingDao.findByUser(userId);
    }

    /**
     * Retrieves ratings made by a user with a specific score.
     * @param userId user ID
     * @param rating rating score
     * @return matching ratings
     */
    @Override
    public List<Rating> getUserRatingsByScore(int userId, int rating) {

        if (userId <= 0 || rating < 1 || rating > 5) {
            return List.of();
        }

        return ratingDao.findByUserAndRating(userId, rating);
    }

    /**
     * Retrieves the highest-rated songs.
     * @return list of highest-rated songs
     */
    @Override
    public List<Song> getHighestRatedSongs() {
        return ratingDao.findHighestRatedSongs();
    }
}