import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Node> nodes = new ArrayList<>();

        Node node1 = new Person("Ana-Maria Ungurean");
        Node node2 = new Person("Gabriela Chirila");
        Node node3 = new Person("Cosmin Sorodoc");
        Node node4 = new Person("Dumitru Secrier");

        Node node5 = new Company("Amazon");
        Node node6 = new Company("Centric");
        Node node7 = new Company("Mambu");
        Node node8 = new Company("Continental");

        Company company1 = new Company("Bitfender");
        Company company2 = new Company("Google");


        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);
        nodes.add(node6);
        nodes.add(node7);
        nodes.add(node8);

        for(Node node: nodes)
            System.out.println(node.getName());

        System.out.println(company1.compareTo(company2));





    }
}