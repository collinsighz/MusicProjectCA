package repository;

import entities.Artist;
import entities.Album;
import entities.Genre;
import entities.Song;

import persistence.ArtistDao;
import persistence.AlbumDao;
import persistence.GenreDao;
import persistence.SongDao;

import java.util.List;

/**
 * Implements music library operations.
 * @author Collins
 */
public class MusicLibraryRepositoryImpl implements MusicLibraryRepository {

    private final ArtistDao artistDao;
    private final AlbumDao albumDao;
    private final GenreDao genreDao;
    private final SongDao songDao;

    /**
     * Creates the repository using the required DAOs.
     */
    public MusicLibraryRepositoryImpl(
            ArtistDao artistDao,
            AlbumDao albumDao,
            GenreDao genreDao,
            SongDao songDao) {

        this.artistDao = artistDao;
        this.albumDao = albumDao;
        this.genreDao = genreDao;
        this.songDao = songDao;
    }

    @Override
    public List<Artist> getAllArtists() {
        return artistDao.getAllArtists();
    }

    @Override
    public List<Album> getAlbumsByArtist(int artistId) {
        return albumDao.getAlbumsByArtistId (artistId);
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreDao.getAllGenres();
    }

    @Override
    public List<Song> searchSongsByTitle(String title) {
        return songDao.findByTitle(title);
    }

    @Override
    public List<Song> searchSongsByArtist(String artist) {
        return songDao.findByArtist(artist);
    }

    @Override
    public List<Song> searchSongsByAlbum(String album) {
        return songDao.findByAlbum(album);
    }

    @Override
    public List<Song> searchSongsByGenre(String genre) {
        return songDao.findByGenre(genre);
    }
}