public class Person implements Comparable<Person>, Node {

    private String personName;

    public Person(String personName) {
        this.personName = personName;
    }
    @Override
    public String getName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int compareTo(Person other){
        return this.personName.compareTo(other.getName());
    }

}
