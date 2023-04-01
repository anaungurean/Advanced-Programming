package org.example;

import org.example.Commands.*;

import javax.print.Doc;
import java.io.IOException;

public class Main {
    public static <CreateReportCommand> void main(String[] args) {


        Document doc1 = new Document("1","C:\\Users\\anama\\OneDrive\\Documents\\Requirements sheet _ Neurosurgical App.pdf");

        doc1.setTitle("Requirements sheet");
        doc1.addTag("Project", "NeuroApp");

        CommandViewDoc viewCommand = new CommandViewDoc(doc1);
      //  viewCommand.execute();

        Document doc2 = new Document("2", "C:\\Users\\anama\\OneDrive\\Documents\\Backlog _ Neurosurgical App.pdf");
        doc2.setTitle("Backlog");
        doc2.addTag("Project", "NeuroApp");


        Document doc3 = new Document("3","C:\\Users\\anama\\OneDrive\\Documents\\Project Ideas.pdf");
        doc3.setTitle("Project Ideas");
        doc3.addTag("Subject", "Software Engineering");

        Catalog catalog =new Catalog("Software Engineering Project");

        CommandAddDoc addDoc = new CommandAddDoc(catalog,doc1);
        addDoc.execute();

        addDoc.setDocument(doc2);
        addDoc.execute();

        addDoc.setDocument(doc3);
        addDoc.execute();

        System.out.println(catalog);

        CommandCreateReport createReport = new CommandCreateReport(catalog);
        createReport.execute();

        CommandListDoc listDoc = new CommandListDoc(catalog);
        listDoc.execute();

        CommandSaveDoc saveDoc = new CommandSaveDoc("C:\\Users\\anama\\OneDrive\\Documents\\catalog.json",catalog);
        saveDoc.execute();

        Catalog loadedCatalog = new CommandLoadCatalog("C:\\Users\\anama\\OneDrive\\Documents\\catalog.json").createCatalog();

        //loadedCatalog.setName("Loaded Catalog");
        //listDoc.setCatalog(loadedCatalog);
        //listDoc.execute();

    }

    }
