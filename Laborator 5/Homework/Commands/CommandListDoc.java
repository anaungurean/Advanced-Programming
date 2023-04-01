package org.example.Commands;

import org.example.Catalog;
import org.example.Document;

public class CommandListDoc implements Command {

    private Catalog catalog;

    public CommandListDoc(Catalog catalog) {
        this.catalog = catalog;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute() {
        System.out.println("Catalog name: " + catalog.getName());
        for(Document document : catalog.getDocs())
            System.out.println("\t" + document);

    }
}
