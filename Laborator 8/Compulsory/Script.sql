CREATE TABLE albums (
  id INT PRIMARY KEY,
  release_year INT,
  title VARCHAR(255),
  artist VARCHAR(255),
  genre_id INT,
  FOREIGN KEY (genre_id) REFERENCES genres(id)
);

CREATE TABLE artists (
  id INT PRIMARY KEY,
  name VARCHAR(255)
);

CREATE TABLE genres (
  id INT PRIMARY KEY,
  name VARCHAR(255)
);

CREATE TABLE album_genres (
  album_id INT,
  genre_id INT,
  FOREIGN KEY (album_id) REFERENCES albums(id),
  FOREIGN KEY (genre_id) REFERENCES genres(id),
  PRIMARY KEY (album_id, genre_id)
);
