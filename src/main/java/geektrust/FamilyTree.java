package geektrust;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

  public FamilyMember getFamilyMember(String memberName) {
    return familyMembers.computeIfAbsent(memberName,
      (name) -> { throw new IllegalArgumentException(String.format("Member name %s doesn't exist", name)); });
  }

  public FamilyMember addChild(String motherName, String childName, Gender childGender) {
    FamilyMember child = new FamilyMember(childName, childGender);
    addFamilyMember(child);
    Couple couple = getCoupleByMotherName(motherName);
    couple.addChild(child);
    return child;
  }

  public Couple marry(String memberName, String spouseName, Gender spouseGender) {
    FamilyMember member = getFamilyMemberToMarry(memberName);
    FamilyMember spouse = new FamilyMember(spouseName, spouseGender);
    addFamilyMember(spouse);
    return new Couple(member, spouse);
  }

  private void addFamilyMember(FamilyMember familyMember) {
    if(hasFamilyMember(familyMember.getName())) {
      throw new IllegalArgumentException(String.format("Family member %s already exists", familyMember.getName()));
    }

    this.familyMembers.put(familyMember.getName(), familyMember);
  }

  private Couple getCoupleByMotherName(String motherName) {
    FamilyMember mother = getFamilyMember(motherName);
    if(!mother.getGender().equals(FEMALE)) {
      throw new IllegalArgumentException(String.format("The name %s is not female", motherName));
    }
    return mother.getCouple().orElseThrow(
      () -> new IllegalArgumentException(String.format("%s has no spouse yet", motherName)));
  }

  private FamilyMember getFamilyMemberToMarry(String memberName) {
    FamilyMember member = getFamilyMember(memberName);
    if(member.isMarried()) {
      throw new IllegalArgumentException(String.format("%s is already married", memberName));
    }
    return member;
  }
}
