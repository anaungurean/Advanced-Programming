import java.util.ArrayList;
import java.util.List;

public class Network {

    private List<Node> nodes= new ArrayList<>();

    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public  int compareByImportance(Node node1, Node node2)
    {
        return node2.gradeOfImportance() - node1.gradeOfImportance();
    }

    public void sortByImportance()
    {
        this.nodes.sort( (Node node1, Node node2 ) -> {
        return compareByImportance(node1,node2);
    });

    }

    @Override
    public String toString() {

        sortByImportance();
        StringBuilder network = new StringBuilder();
        for(Node node : this.nodes){
            network.append(node + "\n");
        }
        return network.toString();
    }

}
