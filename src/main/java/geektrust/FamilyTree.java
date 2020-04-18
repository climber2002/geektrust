package geektrust;

import java.util.HashMap;
import java.util.Map;

import static geektrust.Gender.FEMALE;

public class FamilyTree {
  private final Couple kingCouple;
  private final Map<String, FamilyMember> familyMembers = new HashMap<>();

  public FamilyTree(FamilyMember king, FamilyMember queen) {
    this.kingCouple = new Couple(king, queen);
    addFamilyMember(king);
    addFamilyMember(queen);
  }

  public Couple getKingCouple() {
    return this.kingCouple;
  }

  public boolean hasFamilyMember(String name) {
    return familyMembers.containsKey(name);
  }

  public FamilyMember addChild(String motherName, String childName, Gender childGender) {
    FamilyMember child = new FamilyMember(childName, childGender);
    addFamilyMember(child);
    Couple couple = getCoupleByMotherName(motherName);
    couple.addChild(child);
    return child;
  }

  private void addFamilyMember(FamilyMember familyMember) {
    if(hasFamilyMember(familyMember.getName())) {
      throw new IllegalArgumentException(String.format("Family member %s already exists", familyMember.getName()));
    }

    this.familyMembers.put(familyMember.getName(), familyMember);
  }

  private Couple getCoupleByMotherName(String motherName) {
    FamilyMember mother = familyMembers.computeIfAbsent(motherName,
      (name) -> { throw new IllegalArgumentException(String.format("Mother name %s doesn't exist", name)); });
    if(!mother.getGender().equals(FEMALE)) {
      throw new IllegalArgumentException(String.format("The name %s is not female", motherName));
    }
    return mother.getCouple().orElseThrow(
      () -> new IllegalArgumentException(String.format("%s has no spouse yet", motherName)));
  }
}
