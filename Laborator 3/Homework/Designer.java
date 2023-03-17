import java.time.LocalDate;

public class Designer extends Person{

    private String favouriteDesigningPlatform;
    private String behanceUsername;

    public Designer(String personName, LocalDate dateOfBirth, String favouriteDesigningPlatform, String behanceUsername) {
        super(personName, dateOfBirth);
        this.favouriteDesigningPlatform = favouriteDesigningPlatform;
        this.behanceUsername = behanceUsername;
    }

    public String getFavouriteDesigningPlatform() {
        return favouriteDesigningPlatform;
    }

    public void setFavouriteDesigningPlatform(String favouriteDesigningPlatform) {
        this.favouriteDesigningPlatform = favouriteDesigningPlatform;
    }

    public String getBehanceUsername() {
        return behanceUsername;
    }

    public void setBehanceUsername(String behanceUsername) {
        this.behanceUsername = behanceUsername;
    }

    @Override
    public String toString() {
        return "Designer{" +
                "personName='" + personName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                " favouriteDesigningPlatform='" + favouriteDesigningPlatform + '\'' +
                ", behanceUsername='" + behanceUsername + '\'' +
                ", grade of importance=" + this.gradeOfImportance()  +
                '}';
    }


}
