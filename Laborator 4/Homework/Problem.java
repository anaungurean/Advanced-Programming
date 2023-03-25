package org.example;

import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class Problem {

    private List<Student> students = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();


    public Problem(List<Student> students, List<Project> projects) {
        this.students = students;
        this.projects = projects;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "students=" + students +
                ", projects=" + projects +
                '}';
    }

    public double determineAvgNumPreferences() {

        return students.stream().mapToInt(s -> s.getAdmissibleProjects().size()).average().orElse(0.0);

    }

    public void displayStudentsWithLessPreferences() {
        System.out.println("The students that have a number of preferences lower than the average number of preferences:");
        students.stream().filter(s -> s.getAdmissibleProjects().size() < determineAvgNumPreferences()).forEach(System.out::println);
    }

    public List<Pair<Student, Project>> findMatching() {
        List<Pair<Student, Project>> matching = new ArrayList<>();
        List<Project> givenProject = new ArrayList<>();

        for (Student student : students) {
            List<Project> admissibleProjects = student.getAdmissibleProjects();
             for (Project project : admissibleProjects) {
                if (!givenProject.contains(project))
                {
                    Pair<Student, Project> pair = Pair.of(student, project);
                    matching.add(pair);
                    givenProject.add(project);
                    break;
                }
            }}

            return matching;
    }
}