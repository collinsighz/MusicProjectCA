package persistence;

import entities.Artist;
import java.util.List;

public interface ArtistDao {

    List<Artist> getAllArtists();

}
