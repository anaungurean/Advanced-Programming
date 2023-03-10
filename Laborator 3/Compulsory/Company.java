public class Company implements Comparable<Company>,Node {

    private String companyName;

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
    public int compareTo(Company other){
        return this.companyName.compareTo(other.getName());
    }
}
