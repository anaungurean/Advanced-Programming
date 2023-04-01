package org.example.Commands;

import org.example.Catalog;
import org.example.Document;
import org.example.Exceptions.DuplicateIdException;

public class CommandAddDoc implements Command {
    private Catalog catalog;

    private Document document;


    public Catalog getCatalog() {
        return this.catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Document getDocument() {
        return this.document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public CommandAddDoc(Catalog catalog, Document document) {
        this.catalog = catalog;
        this.document = document;
    }

    public void execute() {
        if (this.document.isValid())
            try {
                if (this.catalog.getDocs().indexOf(this.document) == -1) {
                    this.catalog.getDocs().add(this.document);
                } else {
                    throw new DuplicateIdException(this.document.getId() + " is the same id");
                }
            } catch (DuplicateIdException e) {
                System.out.println("Warning you tried to introduce in a catalogue 2 documents with the same id (" + e.toString() + ")");
            }
    }
}
