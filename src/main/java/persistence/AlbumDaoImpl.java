package persistence;

import entities.Album;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * MySQL implementation of AlbumDao.
 *
 * @author Niharika Madan
 */
public class AlbumDaoImpl implements AlbumDao {

    private final Connector connector;

    /**
     * Creates an album DAO using the supplied database connector.
     *
     * @param connector the database connector
     */
    public AlbumDaoImpl(Connector connector) {
        this.connector = connector;
    }

    /**
     * Retrieves albums belonging to a particular artist.
     *
     * @param artistId the artist ID
     * @return a list of albums by the artist
     */
    @Override
    public List<Album> getAlbumsByArtistId(int artistId) {
        List<Album> albums = new ArrayList<>();

        String sql = "SELECT album_id, artist_id, album_title, release_date, description "
                + "FROM albums WHERE artist_id = ? ORDER BY album_title";

        Connection connection = connector.getConnection();

        if (connection == null) {
            System.out.println("Could not connect to the database.");
            return albums;
        }

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, artistId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    albums.add(mapAlbum(resultSet));
                }
            }

        } catch (SQLException e) {
            System.out.println("Could not retrieve albums: " + e.getMessage());

        } finally {
            connector.freeConnection();
        }

        return albums;
    }

    /**
     * Finds an album using its ID.
     *
     * @param albumId the album ID
     * @return the album if found, otherwise empty
     */
    @Override
    public Optional<Album> getAlbumById(int albumId) {
        String sql = "SELECT album_id, artist_id, album_title, release_date, description "
                + "FROM albums WHERE album_id = ?";

        Connection connection = connector.getConnection();

        if (connection == null) {
            System.out.println("Could not connect to the database.");
            return Optional.empty();
        }

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, albumId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapAlbum(resultSet));
                }
                return Optional.empty();
            }

        } catch (SQLException e) {
            System.out.println("Could not retrieve album: " + e.getMessage());
            return Optional.empty();

        } finally {
            connector.freeConnection();
        }
    }

    /**
     * Converts a database row into an Album record.
     *
     * @param resultSet the current database row
     * @return the album represented by the row
     * @throws SQLException if a database value cannot be read
     */
    private Album mapAlbum(ResultSet resultSet) throws SQLException {
        return new Album(
                resultSet.getInt("album_id"),
                resultSet.getInt("artist_id"),
                resultSet.getString("album_title"),
                resultSet.getDate("release_date"),
                resultSet.getString("description")
        );
    }
}
