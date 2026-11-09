package persistence;

import entities.Rating;
import entities.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RatingDaoImpl implements RatingDao {

    private final Connector connector;


    public RatingDaoImpl(Connector connector) {
        this.connector = connector;
    }


    @Override
    public boolean saveRating(Rating rating) {

        String sql = "INSERT INTO ratings (user_id, song_id, rating) " +
                "VALUES (?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE rating = ?, updated_at = CURRENT_TIMESTAMP";

        try {
            Connection connection = connector.getConnection();

            if (connection == null) {
                return false;
            }

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setInt(1, rating.userId());
                statement.setInt(2, rating.songId());
                statement.setInt(3, rating.rating());
                statement.setInt(4, rating.rating());

                return statement.executeUpdate() > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            connector.freeConnection();
        }
    }


    @Override
    public List<Rating> findByUser(int userId) {

        String sql = "SELECT * FROM ratings WHERE user_id = ?";

        return getRatings(sql, userId, null);
    }


    @Override
    public List<Rating> findByUserAndRating(int userId, int rating) {

        String sql = "SELECT * FROM ratings WHERE user_id = ? AND rating = ?";

        return getRatings(sql, userId, rating);
    }


    @Override
    public List<Song> findHighestRatedSongs() {

        List<Song> songs = new ArrayList<>();

        String sql = "SELECT s.song_id, s.artist_id, s.album_id, s.genre_id, s.song_title " +
                "FROM songs s JOIN ratings r ON s.song_id = r.song_id " +
                "GROUP BY s.song_id, s.artist_id, s.album_id, s.genre_id, s.song_title " +
                "HAVING AVG(r.rating) = (" +
                "SELECT MAX(song_average) FROM (" +
                "SELECT AVG(rating) AS song_average FROM ratings GROUP BY song_id" +
                ") AS averages)";

        try {
            Connection connection = connector.getConnection();

            if (connection == null) {
                return songs;
            }

            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {

                    int albumId = resultSet.getInt("album_id");
                    Integer nullableAlbumId = resultSet.wasNull() ? null : albumId;

                    songs.add(new Song(
                            resultSet.getInt("song_id"),
                            resultSet.getInt("artist_id"),
                            nullableAlbumId,
                            resultSet.getInt("genre_id"),
                            resultSet.getString("song_title")
                    ));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connector.freeConnection();
        }

        return songs;
    }


    private List<Rating> getRatings(String sql, int userId, Integer rating) {

        List<Rating> ratings = new ArrayList<>();

        try {
            Connection connection = connector.getConnection();

            if (connection == null) {
                return ratings;
            }

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setInt(1, userId);

                if (rating != null) {
                    statement.setInt(2, rating);
                }

                try (ResultSet resultSet = statement.executeQuery()) {

                    while (resultSet.next()) {

                        ratings.add(new Rating(
                                resultSet.getInt("user_id"),
                                resultSet.getInt("song_id"),
                                resultSet.getInt("rating"),
                                resultSet.getTimestamp("rated_at").toLocalDateTime(),
                                resultSet.getTimestamp("updated_at").toLocalDateTime()
                        ));
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connector.freeConnection();
        }

        return ratings;
    }
}