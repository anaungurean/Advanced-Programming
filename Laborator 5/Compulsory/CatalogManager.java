package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class CatalogManager {

    public void addDocument(String id, String title, String location, Catalog catalog) {
        Document document = new Document(id, title, location);
        catalog.addDocument(document);
    }

    public CatalogManager() {
    }

    public static void save(Catalog catalog, String path)
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog);
    }

    public static Catalog load(String path)
            throws CatalogManager.InvalidCatalogException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(
                new File(path),
                Catalog.class);

        return catalog;

    }

    public String toString(Catalog catalog) {
        return "CatalogManger{" +
                "catalog=" + catalog +
                '}';
    }

    protected static class InvalidCatalogException extends Exception {
    }
}
