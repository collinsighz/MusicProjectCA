DROP DATABASE IF EXISTS music_library;
CREATE DATABASE music_library;

USE music_library;

-- 1. USERS
CREATE TABLE users (
                       user_id INT AUTO_INCREMENT PRIMARY KEY,
                       first_name VARCHAR(100) NOT NULL,
                       last_name VARCHAR(100) NOT NULL,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       email VARCHAR(254) NOT NULL UNIQUE,
                       password_hash VARCHAR(255) NOT NULL
);

-- 2. ARTISTS
CREATE TABLE artists (
                         artist_id INT AUTO_INCREMENT PRIMARY KEY,
                         artist_name VARCHAR(150) NOT NULL UNIQUE
);

-- 3. ALBUMS
CREATE TABLE albums (
                        album_id INT AUTO_INCREMENT PRIMARY KEY,
                        artist_id INT NOT NULL,
                        album_title VARCHAR(200) NOT NULL,
                        release_date DATE,
                        description TEXT,

                        CONSTRAINT fk_albums_artist
                            FOREIGN KEY (artist_id)
                                REFERENCES artists(artist_id),

                        CONSTRAINT uq_album_artist_title
                            UNIQUE (artist_id, album_title)
);

-- 4. GENRES
CREATE TABLE genres (
                        genre_id INT AUTO_INCREMENT PRIMARY KEY,
                        genre_name VARCHAR(80) NOT NULL UNIQUE
);

-- 5. SONGS
CREATE TABLE songs (
                       song_id INT AUTO_INCREMENT PRIMARY KEY,
                       artist_id INT NOT NULL,
                       album_id INT NULL,
                       genre_id INT NOT NULL,
                       song_title VARCHAR(200) NOT NULL,

                       CONSTRAINT fk_songs_artist
                           FOREIGN KEY (artist_id)
                               REFERENCES artists(artist_id),

                       CONSTRAINT fk_songs_album
                           FOREIGN KEY (album_id)
                               REFERENCES albums(album_id),

                       CONSTRAINT fk_songs_genre
                           FOREIGN KEY (genre_id)
                               REFERENCES genres(genre_id)
);

-- 6. RATINGS
CREATE TABLE ratings (
                         user_id INT NOT NULL,
                         song_id INT NOT NULL,
                         rating TINYINT NOT NULL,
                         rated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
                             ON UPDATE CURRENT_TIMESTAMP,

                         PRIMARY KEY (user_id, song_id),

                         CONSTRAINT fk_ratings_user
                             FOREIGN KEY (user_id)
                                 REFERENCES users(user_id),

                         CONSTRAINT fk_ratings_song
                             FOREIGN KEY (song_id)
                                 REFERENCES songs(song_id),

                         CONSTRAINT chk_rating_range
                             CHECK (rating BETWEEN 1 AND 5)
);