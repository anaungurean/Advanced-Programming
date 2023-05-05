package org.example;

public class Genre extends MusicEntity{
    private String name;

    public Genre(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + this.getId()+
                ", name='" + name + '\'' +
                '}';
    }
}
