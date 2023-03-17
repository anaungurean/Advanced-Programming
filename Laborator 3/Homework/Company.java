import java.util.HashMap;
import java.util.Map;

public class Company implements Comparable<Company>,Node {

    private String companyName;
    private Map<Node,String> relationship = new HashMap<>();

    public Company(String companyName) {
        this.companyName = companyName;
    }
    @Override
    public String getName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                '}';
    }
    public int gradeOfImportance(){
        return this.relationship.size();
    }

     public void addRelationship(Node node, String value) {
         relationship.put(node,value);
     }
    public int compareTo(Company other){
        return this.companyName.compareTo(other.getName());
    }

}
