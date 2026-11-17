package persistence;

import entities.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements database operations for songs.
 * @author Collins
 */
public class SongDaoImpl implements SongDao {

    private final Connector connector;

    /**
     * Creates a SongDaoImpl using the  connector.
     * @param connector database connector
     */
    public SongDaoImpl(Connector connector) {
        this.connector = connector;
    }

    /**
     * Retrieves all songs.
     * @return list of songs
     */
    @Override
    public List<Song> findAll() {

        List<Song> songs = new ArrayList<>();

        String sql = "SELECT song_id, artist_id, album_id, genre_id, song_title FROM songs";

        try {
            Connection connection = connector.getConnection();

            if (connection == null) {
                return songs;
            }

            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    songs.add(mapSong(resultSet));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connector.freeConnection();
        }

        return songs;
    }

    /**
     * Searches songs by title.
     * @param title song title
     * @return matching songs
     */
    @Override
    public List<Song> findByTitle(String title) {

        String sql = "SELECT song_id, artist_id, album_id, genre_id, song_title " +
                "FROM songs WHERE song_title LIKE ?";

        return searchSongs(sql, "%" + title + "%");
    }

    /**
     * Searches songs by artist.
     * @param artist artist name
     * @return matching songs
     */
    @Override
    public List<Song> findByArtist(String artist) {

        String sql = "SELECT s.song_id, s.artist_id, s.album_id, s.genre_id, s.song_title " +
                "FROM songs s JOIN artists a ON s.artist_id = a.artist_id " +
                "WHERE a.artist_name LIKE ?";

        return searchSongs(sql, "%" + artist + "%");
    }

    /**
     * Searches songs by album.
     * @param album album title
     * @return matching songs
     */
    @Override
    public List<Song> findByAlbum(String album) {

        String sql = "SELECT s.song_id, s.artist_id, s.album_id, s.genre_id, s.song_title " +
                "FROM songs s JOIN albums a ON s.album_id = a.album_id " +
                "WHERE a.album_title LIKE ?";

        return searchSongs(sql, "%" + album + "%");
    }

    /**
     * Searches songs by genre.
     * @param genre genre name
     * @return matching songs
     */
    @Override
    public List<Song> findByGenre(String genre) {

        String sql = "SELECT s.song_id, s.artist_id, s.album_id, s.genre_id, s.song_title " +
                "FROM songs s JOIN genres g ON s.genre_id = g.genre_id " +
                "WHERE g.genre_name LIKE ?";

        return searchSongs(sql, "%" + genre + "%");
    }

    /**
     * Executes a song search query.
     * @param sql SQL query
     * @param value search value
     * @return matching songs
     */
    private List<Song> searchSongs(String sql, String value) {

        List<Song> songs = new ArrayList<>();

        try {
            Connection connection = connector.getConnection();

            if (connection == null) {
                return songs;
            }

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, value);

                try (ResultSet resultSet = statement.executeQuery()) {

                    while (resultSet.next()) {
                        songs.add(mapSong(resultSet));
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connector.freeConnection();
        }

        return songs;
    }

    /**
     * Converts a database row into a Song record.
     * @param resultSet database results
     * @return song record
     * @throws SQLException if a database error occurs
     */
    private Song mapSong(ResultSet resultSet) throws SQLException {

        int albumId = resultSet.getInt("album_id");

        Integer nullableAlbumId = resultSet.wasNull() ? null : albumId;

        return new Song(
                resultSet.getInt("song_id"),
                resultSet.getInt("artist_id"),
                nullableAlbumId,
                resultSet.getInt("genre_id"),
                resultSet.getString("song_title")
        );
    }
}