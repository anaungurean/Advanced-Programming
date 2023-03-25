package org.example;

import java.util.ArrayList;
import java.util.List;


    public class Catalog {

        private String name;
        private List<Document> docs = new ArrayList<>();

        public Catalog() {
        }

        public Catalog(String name) {
            this.name = name;
        }

        public Catalog(String name, List<Document> docs) {
            this.name = name;
            this.docs = docs;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void addDocument(Document doc){

            docs.add(doc);
        }

        public List<Document> getDocs() {
            return docs;
        }

        @Override
        public String toString() {
            return "Catalog{" +
                    "name='" + name + '\'' +
                    ", docs=" + docs +
                    '}';
        }
    }

