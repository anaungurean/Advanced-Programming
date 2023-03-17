import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Node> nodes = new ArrayList<>();

        Person person1 = new Programmer("Ana-Maria Ungurean", LocalDate.of(2002,9,1), "Java","ana.ungurean");
        Person person2 = new Programmer("Gabriela Chirila",  LocalDate.of(2002,9,23),"CSS", "gabriela.chirila");
        Person person3 = new Programmer("Cosmin Sorodoc",  LocalDate.of(2003,4,22),"Coq", "cosmin.sorodoc");
        Person person4 = new Designer("Diana Carcea",  LocalDate.of(2002,5,27),"Canva", "diana.carcea");
        Person person5 = new Designer("Florina Bodnar",  LocalDate.of(2003,4,5), "Sketch", "florina.bodnar");
        Person person6 = new Designer("Emanuela Mistreanu", LocalDate.of(2002,9,18), "Adobe", "emanuela.mistreanu");

        Company company1 = new Company("Karlsberg");

        company1.addRelationship(person1,"employee");
        company1.addRelationship(person2,"employee");
        company1.addRelationship(person3,"employee");
        company1.addRelationship(person4,"employee");
        company1.addRelationship(person5,"employee");
        company1.addRelationship(person6,"employee");

        person1.addRelationship(company1,"CEO");
        person1.addRelationship(person2,"coworker");
        person1.addRelationship(person3,"employer");
        person1.addRelationship(person4,"employer");
        person1.addRelationship(person5,"employer");
        person1.addRelationship(person6,"employer");

        person2.addRelationship(company1,"manager");
        person2.addRelationship(person1,"coworker");
        person2.addRelationship(person3,"mentor");
        person2.addRelationship(person6,"collaborator");

        person3.addRelationship(company1,"employee");
        person3.addRelationship(person2,"mentee");

        person4.addRelationship(company1,"employee");
        person4.addRelationship(person5,"mentor");
        person4.addRelationship(person6,"coworker");

        person5.addRelationship(company1,"employee");
        person5.addRelationship(person4,"mentee");
        person5.addRelationship(person6,"coworker");

        person6.addRelationship(company1,"employee");
        person6.addRelationship(person4,"coworker");
        person6.addRelationship(person2,"collaborator");

        nodes.add(company1);
        nodes.add(person1);
        nodes.add(person2);
        nodes.add(person3);
        nodes.add(person4);
        nodes.add(person5);
        nodes.add(person6);

        Network network = new Network(nodes);
        System.out.println(network);

    }
}