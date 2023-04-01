package org.example.Commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Catalog;

import java.io.File;
import java.io.IOException;

public class CommandLoadCatalog {

    private String location;

    public CommandLoadCatalog(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Catalog createCatalog() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(new File(location), Catalog.class);
        }
        catch (IOException e) {
            System.out.println("The location for loading is not valid");;
        }

        return null;
    }






}
