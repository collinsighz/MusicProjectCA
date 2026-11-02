package repository;

import entities.Genre;
import persistence.GenreDao;

import java.util.List;

/**
 * Implementation of GenreRepository using GenreDao.
 *
 * @author Niharika Madan
 */
public class GenreRepositoryImpl implements GenreRepository {

    private final GenreDao genreDao;

    /**
     * Creates a genre repository using the supplied DAO.
     *
     * @param genreDao the genre data access object
     */
    public GenreRepositoryImpl(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    /**
     * Retrieves all genres from the music library.
     *
     * @return a list of all genres
     */
    @Override
    public List<Genre> getAllGenres() {
        return genreDao.getAllGenres();
    }
}