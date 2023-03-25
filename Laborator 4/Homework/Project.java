package org.example;

public class Project implements  Comparable<Project> {
    String projectName;
    public Project(String projectName) {
        this.projectName = projectName;
    }
    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public int compareTo(Project other) {
        return this.projectName.compareTo(other.getProjectName());
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                '}';
    }



}