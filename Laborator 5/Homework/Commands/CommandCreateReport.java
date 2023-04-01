package org.example.Commands;

import org.example.Catalog;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;

public class CommandCreateReport {

    private Catalog catalog;

    public CommandCreateReport(Catalog catalog) {
        this.catalog = catalog;
    }

    public void execute(){

        //Configuration config = new Configuration();
        Configuration config = new Configuration(new Version("2.3.31"));
        config.setClassForTemplateLoading(CommandCreateReport.class,"/Templates");
        config.setDefaultEncoding("UTF-8");

        try {
            Template template = config.getTemplate("htmlTemplate.ftl");

            Writer htmlFile = new FileWriter("a.html");

            Map<String, Catalog> templateData = new HashMap<>();
            templateData.put("catalog", this.catalog);

            template.process(templateData, htmlFile);
            htmlFile.close();
        }
        catch (IOException e) {
            System.out.println("The report couldn't be done because the template file could not be found or it was an error writing in the .html file");
        }
        catch (TemplateException e) {
            System.out.println("Error at creating the report");
        }
    }





}
