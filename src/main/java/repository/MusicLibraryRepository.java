package repository;

import entities.Artist;
import entities.Album;
import entities.Genre;
import entities.Song;

import java.util.List;

/**
 * Handles music library browsing and searching.
 * @author Collins
 */
public interface MusicLibraryRepository {

    /**
     * Retrieves all artists.
     * @return list of artists
     */
    List<Artist> getAllArtists();

    /**
     * Retrieves albums by artist.
     * @param artistId artist ID
     * @return list of albums
     */
    List<Album> getAlbumsByArtist(int artistId);

    /**
     * Retrieves all genres.
     * @return list of genres
     */
    List<Genre> getAllGenres();

    /**
     * Searches songs by title.
     * @param title
     * @return matching songs
     */
    List<Song> searchSongsByTitle(String title);

    /**
     * Searches songs by artist.
     * @param artist
     * @return matching songs
     */
    List<Song> searchSongsByArtist(String artist);

    /**
     * Searches songs by album.
     * @param album
     * @return matching songs
     */
    List<Song> searchSongsByAlbum(String album);

    /**
     * Searches songs by genre.
     * @param genre
     * @return matching songs
     */
    List<Song> searchSongsByGenre(String genre);
}