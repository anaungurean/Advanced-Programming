# Laborator 12

## Reflection - Java Class Analysis and Testing

Develop an application to analyze and test Java classes. The application will take Java class files as input, display their prototypes, and perform tests specified by the `@Test` annotation.

## Main Specifications

### Compulsory (1p)

- The input will be a `.class` file located anywhere in the file system.
- Load the specified class in memory, dynamically identifying its package.
- Utilize reflection to extract information about the class, including its methods.
- Use reflection to invoke static methods, annotated with `@Test`, which have no arguments.

---
