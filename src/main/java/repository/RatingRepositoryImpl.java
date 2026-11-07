package repository;

import entities.Rating;
import entities.Song;
import persistence.RatingDao;
import repository.RatingRepository;

import java.util.List;

/**
 * Implements song rating operations.
 * @author Collins
 */
public class RatingRepositoryImpl implements RatingRepository {

    private final RatingDao ratingDao;

    /**
     * Creates the repository using the rating DAO.
     * @param ratingDao rating DAO
     */
    public RatingRepositoryImpl(RatingDao ratingDao) {
        this.ratingDao = ratingDao;
    }

    @Override
    public boolean rateSong(Rating rating) {
        return ratingDao.saveRating(rating);
    }

    @Override
    public List<Rating> getUserRatings(int userId) {
        return ratingDao.findByUser(userId);
    }

    @Override
    public List<Rating> getUserRatingsByScore(int userId, int rating) {
        return ratingDao.findByUserAndRating(userId, rating);
    }

    @Override
    public List<Song> getHighestRatedSongs() {
        return ratingDao.findHighestRatedSongs();
    }
}