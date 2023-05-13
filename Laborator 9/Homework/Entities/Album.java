package org.example.Entities;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Album.findByName", query = "SELECT a FROM Album a WHERE LOWER(a.title) LIKE LOWER(:name)")
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="release_year")
    private int releaseYear;
    @Column(name="title")
    private String title;


    public Album() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Album( String title,int releaseYear) {
        this.releaseYear = releaseYear;
        this.title = title;
    }
}