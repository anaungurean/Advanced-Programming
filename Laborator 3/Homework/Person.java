import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

abstract class Person implements Comparable<Person>, Node {

    protected String personName;
    protected LocalDate dateOfBirth;
    protected Map<Node,String> relationship = new HashMap<>();

    public Person(String personName, LocalDate dateOfBirth) {
        this.personName = personName;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String getName() {
        return personName;
    }

    public Map<Node, String> getRelationship() {
        return relationship;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int compareTo(Person other){
        return this.personName.compareTo(other.getName());
    }

    public void addRelationship(Node node, String value){
        relationship.put(node,value);
    }

    public  int gradeOfImportance(){
       return this.relationship.size();
    }

}
