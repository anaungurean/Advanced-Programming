package org.example;

import java.util.*;
import java.util.stream.Collectors;
import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        List<Project> projects = new ArrayList<>();
        Faker faker = new Faker();

        Project p0 = new Project(faker.app().name());
        Project p1 = new Project(faker.app().name());
        Project p2 = new Project(faker.app().name());

        Student s0= new Student(faker.name().fullName(), Arrays.asList(p0,p1,p2));
        Student s1= new Student(faker.name().fullName(), Arrays.asList(p1,p2));
        Student s2= new Student(faker.name().fullName(), Arrays.asList(p0));

        students.add(s0);
        students.add(s1);
        students.add(s2);

        projects.add(p0);
        projects.add(p1);
        projects.add(p2);

        Problem instance = new Problem(students,projects);

        //System.out.println(instance);
       // instance.displayStudentsWithLessPreferences();

        System.out.println(instance.findMatching());

    }
}