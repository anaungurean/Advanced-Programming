package org.example.Entities;

import jakarta.persistence.Entity;

@Entity
public abstract class MusicEntity {
    private  int id;

    public MusicEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
