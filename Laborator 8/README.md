# Laborator 8

## JDBC - Relational Database Interaction

Develop an application that enables connecting to a relational database using JDBC, executing SQL statements, and presenting the outcomes.

## Main Specifications

### Compulsory (1p)

- Set up a relational database using any RDBMS (Oracle, Postgres, MySql, Java DB, etc.).
- Write an SQL script to create the subsequent tables:
  - `albums`: id, release year, title, artist, genre(s)
  - `artists`: id, name (e.g., Beatles)
  - `genres`: id, name (e.g., Rock)
  - Generate an associative (junction) table to hold album-genre relationships.
- Update `pom.xml` to include the database driver in the project libraries.
- Establish a singleton class to manage the database connection.
- Construct DAO classes that offer methods for handling artists, genres, and albums (at least one).
- Execute a simple test using your classes.

### Optional (2p)

- Create an object-oriented data model corresponding to the Java application's managed data.
- Implement all the DAO classes.
- Adopt a connection pool to manage database connections, such as C3PO, HikariCP, or Apache Commons DBCP.
- Develop a tool for importing data from a tangible dataset, such as Rolling Stone's 500 Greatest Albums of All Time or another source.

---

 
