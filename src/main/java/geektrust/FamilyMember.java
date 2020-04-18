package geektrust;

import java.util.Optional;

import static geektrust.Gender.MALE;

public class FamilyMember {
  private final String name;
  private final Gender gender;

  private Optional<Couple> couple = Optional.empty();
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

  void setCouple(Couple couple) {
    this.couple = Optional.of(couple);
  }

  public Optional<Couple> getCouple() {
    return this.couple;
  }

  public Optional<FamilyMember> getSpouse() {
    return this.couple.map(couple -> {
      if(this.getGender().equals(MALE)) {
        return couple.getFemaleSpouse();
      } else {
        return couple.getMaleSpouse();
      }
    });
  }

  public Optional<FamilyMember> getFather() {
    return this.parents.map(couple -> couple.getMaleSpouse());
  }

  public Optional<FamilyMember> getMother() {
    return this.parents.map(couple -> couple.getFemaleSpouse());
  }

  public boolean isMarried() {
    return this.couple.isPresent();
  }
}
