package geektrust;

import java.util.Optional;

public class FamilyMember {
  private final String name;
  private final Gender gender;
  private Optional<Couple> parents = Optional.empty();

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

  public void setParents(Couple couple) {
    this.parents = Optional.of(couple);
  }

  public Optional<Couple> getParents() {
    return this.parents;
  }
}
