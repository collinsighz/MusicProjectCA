package persistence;

import entities.Song;
import java.util.List;

/**
 * all song methods.
 * @author Collins
 */
public interface SongDao {

    /**
     * Retrieves all songs.
     * @return list of songs
     * @author collins
     */
    List<Song> findAll();

    /**
     * Search songs by title.
     * @param title
     * @return matching songs
     * @author collins
     */
    List<Song> findByTitle(String title);

    /**
     * Searches songs by artist.
     * @param artist
     * @return matching songs
     * @author collins
     */
    List<Song> findByArtist(String artist);

    /**
     * Searcs the songs by album.
     * @param album
     * @return matching songs
     */
    List<Song> findByAlbum(String album);

    /**
     * Search songs by genre
     * @param genre g
     * @return matching songs
     * @author collins
     */
    List<Song> findByGenre(String genre);
}