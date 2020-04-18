package geektrust.relationships;

import geektrust.Couple;
import geektrust.FamilyMember;
import geektrust.FamilyTree;
import geektrust.Gender;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractRelationship {
  protected final String memberName;
  protected final FamilyTree familyTree;

  public AbstractRelationship(String memberName, FamilyTree familyTree) {
    this.memberName = memberName;
    this.familyTree = familyTree;
  }

  public abstract List<FamilyMember> get();

  public List<String> getNames() {
    return get().stream().map(member -> member.getName()).collect(Collectors.toList());
  }

  protected FamilyMember getFamilyMember() {
    return familyTree.getFamilyMember(memberName);
  }

  protected List<FamilyMember> getChildrenOfGender(Couple couple, Gender gender) {
    return couple.getChildren().stream().filter(child -> child.getGender().equals(gender)).collect(Collectors.toList());
  }
}
