package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, CatalogManager.InvalidCatalogException {

        Catalog catalog = new Catalog("MyDocuments");
        var book = new Document("book1", "The great Gatsby", "C:\\Users\\anama\\OneDrive" );
        var article = new Document("article1", "Newspaper", "C:\\Users\\anama\\OneDrive ");
        catalog.addDocument(book);
        catalog.addDocument(article);

        //CatalogUtil.save(catalog, "C:\\Users\\anama\\OneDrive\\Desktop\\n.json");
        Catalog catalog1 = CatalogManager.load("C:\\Users\\anama\\OneDrive\\Desktop\\n.json");

        System.out.println(catalog1);


    }
}