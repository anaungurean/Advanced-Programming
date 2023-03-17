public interface Node {
    String getName();
    int gradeOfImportance();
    void addRelationship(Node node, String value);
  }
