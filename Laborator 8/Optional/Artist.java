package org.example;

public class Artist extends MusicEntity{

    private String name;
    public Artist(int id, String name) {
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
        return "Artist{" +
                "id=" + this.getId()+
                ", name='" + name + '\'' +
                '}';
    }
}
