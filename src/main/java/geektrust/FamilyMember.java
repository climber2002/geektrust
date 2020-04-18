package geektrust;

public class FamilyMember {
  private final String name;
  private final Gender gender;

  public FamilyMember(String name, Gender gender) {
    this.name = name;
    this.gender = gender;
  }

  public String getName() {
    return this.name;
  }

  public Gender getGender() {
    return this.gender;
  }
}
