package persistence;

import entities.Rating;
import entities.Song;

import java.util.List;


public interface RatingDao {


    boolean saveRating(Rating rating);


    List<Rating> findByUser(int userId);


    List<Rating> findByUserAndRating(int userId, int rating);


    List<Song> findHighestRatedSongs();
}