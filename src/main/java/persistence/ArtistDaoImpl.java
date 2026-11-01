package persistence;

import entities.Artist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistDaoImpl implements ArtistDao {

    private final Connector connector;

    public ArtistDaoImpl(Connector connector) {
        this.connector = connector;
    }

    @Override
    public List<Artist> getAllArtists() {

        List<Artist> artists = new ArrayList<>();

        String sql = "SELECT artist_id, artist_name FROM artists";

        Connection connection = connector.getConnection();

        if (connection == null) {
            System.out.println("Could not connect to the database.");
            return artists;
        }

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                int artistId = resultSet.getInt("artist_id");
                String artistName = resultSet.getString("artist_name");

                Artist artist = new Artist(artistId, artistName);

                artists.add(artist);
            }

        } catch (SQLException e) {

            System.out.println("Could not retrieve artists: " + e.getMessage());

        } finally {

            connector.freeConnection();
        }

        return artists;
    }
}