package org.example;

import java.util.HashMap;
import java.util.Map;


    public class Document  {
        private String id;
        private String title;
        private String location;

        private Map<String, Object> tags = new HashMap<>();

        public Document(){

        }
        public Document(String id, String title, String location) {
            this.id = id;
            this.title = title;
            this.location = location;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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
            this.location = location;
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
        public String toString() {
            return "Document{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", location='" + location + '\'' +
                    ", tags=" + tags +
                    '}';
        }
    }


