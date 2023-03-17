import java.time.LocalDate;
import java.util.Map;

public class Programmer extends  Person{

  private String favouriteProgrammingLanguage;
  private String githubUsername;

  public Programmer(String personName, LocalDate dateOfBirth, String favouriteProgrammingLanguage, String githubUsername) {
    super(personName, dateOfBirth);
    this.favouriteProgrammingLanguage = favouriteProgrammingLanguage;
    this.githubUsername = githubUsername;
  }

  public String getFavouriteProgrammingLanguage() {
    return favouriteProgrammingLanguage;
  }

  public void setFavouriteProgrammingLanguage(String favouriteProgrammingLanguage) {
    this.favouriteProgrammingLanguage = favouriteProgrammingLanguage;
  }

  public String getGithubUsername() {
    return githubUsername;
  }

  public void setGithubUsername(String githubUsername) {
    this.githubUsername = githubUsername;
  }

  @Override
  public String toString() {
    return "Programmer{" +
            "personName='" + personName + '\'' +
            ", dateOfBirth='" + dateOfBirth + '\'' +
            ", favouriteProgrammingLanguage='" + favouriteProgrammingLanguage + '\'' +
            ", githubUsername='" + githubUsername + '\'' +
            ", grade of importance=" + this.gradeOfImportance()  +
            '}';
  }


}
