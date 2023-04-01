package org.example.Commands;

import org.example.Catalog;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class CommandSaveDoc implements Command{

    private String location;
    private Catalog catalog;

    public CommandSaveDoc(String location, Catalog catalog) {
        this.location = location;
        this.catalog = catalog;
    }

    @Override
    public void execute() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(this.location), this.catalog);
        } catch (IOException exception) {
            System.out.println("The location for saving is not Valid");
        }
    }

    }

