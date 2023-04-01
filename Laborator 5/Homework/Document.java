package org.example;

import org.example.Exceptions.InvalidFileException;
import org.example.Exceptions.PageNotFoundException;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

public class Document implements Serializable,Comparable<Document> {
        private String id;
        private String title;
        private String location;

        private boolean isValid = false;

        private Map<String, Object> tags = new HashMap<>();

        public Document() {

        }

    public Document(String id, String location) {
         setId(id);
         setLocation(location);
    }


        public String getId() {
            return id;
        }

        public void setId(String id) {
            try {
                if (id.equals(""))
                    throw new InvalidFileException("Invalid id");
                this.id = id;
            } catch (InvalidFileException e) {
                System.out.println("The id is invalid, by default it will be set to 1 (Note : if you try to add in a catalog 2 docs with the same id -> the program stops)");
                this.id = "1";
            }

        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            File file = new File(location);
    try {
            if (file.exists() && !file.isDirectory()) {
                this.location = location;
                this.isValid = true;
            } else {
                URL myUrl = new URL(location);
                myUrl.toURI();
                HttpURLConnection connection = (HttpURLConnection)myUrl.openConnection();
                if (connection.getResponseCode() == 404)
                    throw new PageNotFoundException("The website with link : " + location + " couldn't be found");
                this.location = location;
                this.isValid = true;
                throw new InvalidFileException("File with location : " + location + "\ndoesn't exist on this computer");
            }
        }
        catch (InvalidFileException e) {
            System.out.println(e + "(it is actually a link)");
        } catch (PageNotFoundException e) {
            System.out.println(e + "\n(if you try to add it to a catalog, it will not be added)");
        } catch (MalformedURLException e) {
            System.out.println("The location " + location + " is not for a file nor a URL\n(if you try to add it to a catalog, it will not be added)");
        } catch (URISyntaxException e) {
            System.out.println(location + "is not a valid link \n(if you try to add it to a catalog, it will not be added)");
        } catch (IOException e) {
            System.out.println("The connection couldn't have been made with the site \n(if you try to add it to a catalog, it will not be added)");
        }
    }
        public Map<String, Object> getTags() {
            return tags;
        }

        public void setTags(Map<String, Object> tags) {
            this.tags = tags;
        }
        public void addTag(String key, Object obj) {
            tags.put(key, obj);
        }

    @Override
        public int compareTo(Document o) {
            return this.id.compareTo(o.getId());
        }

        public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Document document = (Document)o;
        return Objects.equals(this.id, document.id);
    }

    public int hashCode() {
        return Objects.hash(new Object[] { this.id });
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", isValid=" + isValid +
                ", tags=" + tags +
                '}';
    }

    public boolean isValid() {
            return isValid;
    }
}


