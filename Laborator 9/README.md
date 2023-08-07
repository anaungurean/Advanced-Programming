# Laborator 9

## Persistence - JPA Integration

Extend the application from lab 8 by implementing an object-oriented model and using JPA (Java Persistence API) to communicate with a relational database.

## Main Specifications

### Compulsory (1p)

- Create a persistence unit (use EclipseLink, Hibernate, or another JPA implementation).
- Verify the presence of the `persistence.xml` file in your project. Ensure that the driver for EclipseLink or Hibernate has been added to your project classpath (or add it manually).
- Define entity classes for your model (at least one) and place them in a dedicated package. Utilize IDE support to generate entity classes from database tables.
- Establish a singleton responsible for managing an `EntityManagerFactory` object.
- Define repository classes for your entities (at least one). These classes should contain the following methods:
  - `create`: Accepts an entity and saves it into the database.
  - `findById`: Retrieves an entity based on its primary key.
  - `findByName`: Returns a list of entities that match a given name pattern. Implement this method using a named query.
- Test your application.

### Homework (2p)

- Create all entity classes and repositories. Properly implement the one-to-many and many-to-many relationships.
- Develop a generic `AbstractRepository` using generics to simplify the creation of repository classes. Consider referencing the `CrudRepository` interface from the Spring Framework.
- Use JPA to insert a large number of fake artists and albums into the database. Log the execution time of your JPQL statements.

---

