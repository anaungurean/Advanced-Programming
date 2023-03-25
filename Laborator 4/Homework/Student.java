package org.example;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {
    private String studentName;
    private List<Project> admissibleProjects = new ArrayList<>();
    public Student(String studentName) {
        this.studentName = studentName;
    }

    public Student(String studentName, List<Project> admissibleProjects) {
        this.studentName = studentName;
        this.admissibleProjects = admissibleProjects;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Project> getAdmissibleProjects() {
        return admissibleProjects;
    }

    public void setAdmissibleProjects(List<Project> admissibleProjects) {
        this.admissibleProjects = admissibleProjects;
    }

    @Override
    public int compareTo(Student other) {
        return this.studentName.compareTo(other.getStudentName());
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +

                '}';
    }
}
