package repository;

import entities.Rating;
import entities.Song;
import persistence.RatingDao;

import java.util.List;


/// Operation for rating songs
/// @author Beni
public class RatingRepositoryImpl implements RatingRepository {

    private final RatingDao ratingDao;


    /// Creates a RatingRepositoryImpl
    /// @param ratingDao DAO for rating songs
    public RatingRepositoryImpl(RatingDao ratingDao) {
        this.ratingDao = ratingDao;
    }


    /// @param rating Submit or update a song's rating
    /// @return true upon success
    @Override
    public boolean rateSong(Rating rating) {

        if (rating == null || rating.rating() < 1 || rating.rating() > 5) {
            return false;
        }

        return ratingDao.saveRating(rating);
    }

    /// Retrieve a rating made by a user
    /// @param userId the ID assigned to a user
    /// @return the list of ratings
    @Override
    public List<Rating> getUserRating(int userId) {
        return List.of();
    }

    /// Retrieve a user rating by their score
    /// @param UserId the ID assigned to a user
    /// @param rating the score rating
    /// @return
    @Override
    public List<Rating> getUserRatingByScore(int UserId, int rating) {
        return List.of();
    }


    /// Retrieve a rating that a user has made
    /// @param userId the ID assigned to a user
    /// @return rating if found, false if no match found
    @Override
    public List<Rating> getUserRatings(int userId) {

        if (userId <= 0) {
            return List.of();
        }

        return ratingDao.findByUser(userId);
    }


    @Override
    public List<Rating> getUserRatingsByScore(int userId, int rating) {

        if (userId <= 0 || rating < 1 || rating > 5) {
            return List.of();
        }

        return ratingDao.findByUserAndRating(userId, rating);
    }


    /// Finds the highest-rated songs
    /// @return a list of the highest-rated songs
    @Override
    public List<Song> getHighestRatedSongs() {
        return ratingDao.findHighestRatedSongs();
    }
}