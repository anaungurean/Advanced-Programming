package org.example.Commands;

import org.example.Document;

import javax.print.Doc;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CommandViewDoc implements  Command {

    private Document document;

    public CommandViewDoc(Document document) {
        this.document = document;
    }

    @Override
    public void execute() {
        if (this.document.isValid()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(new File(this.document.getLocation()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("The file " + this.document.getTitle() + " couldn't be open (is not valid)");
        }
    }

}

