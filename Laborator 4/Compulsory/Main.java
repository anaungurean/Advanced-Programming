package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> studentsName= Arrays.asList("S1","S0","S2");
        List<String> projectsName= Arrays.asList("P1","P2","P0");

        List<Student> students = studentsName.stream().map(studentName -> new Student(studentName)).collect(Collectors.toList());
        List<Project> projects= projectsName.stream().map(projectName -> new Project(projectName)).collect(Collectors.toList());

        LinkedList<Student> students1 = new LinkedList<>();
        for (Student s : students)
            students1.add(s);

        Collections.sort(students1);
       for(Student s : students1)
           System.out.println(s);

       TreeSet<Project> projects1 = new TreeSet<>();
       for(Project p : projects)
           projects1.add(p);

       for(Project p : projects1)
           System.out.println(p);


    }
}