# Laborator 4

## The Student-Project Allocation Problem

An instance of this problem consists of students and projects. Each student has a list of projects that are admissible. A matching is a set of pairs (student, project) such that each student is assigned to at most one project and each project is assigned to at most one student. We consider the problem of creating a maximum cardinality matching between students and projects.

**Example**: 3 students (S0, S1, S2) and 3 projects (P0, P1, P2).
Projects considered admissible by: S0={P0, P1, P2}, S1={P0, P1}, S2={P0}.
The maximum cardinality matching should be: {S0-P2, S1-P1, S2-P0}.

## Main Specifications

### Compulsory (1p)

- Create a Maven project.
- Create an object-oriented model of the problem. Students and projects have names. Ensure the objects of these classes are comparable.
- Create the students and the projects described in the example. Utilize streams to easily create the objects.
- Put all the students in a LinkedList and print them sorted by their names.
- Put all the projects in a TreeSet and print them sorted by their names.

### Homework (2p)

- Create a class that describes the problem.
- Utilizing Java Stream API, write a query that displays all the students who have a number of preferences lower than the average number of preferences.
- Employ a third-party library to generate random fake names for students and projects.
- Create a Greedy algorithm in order to solve the problem.

---

 
