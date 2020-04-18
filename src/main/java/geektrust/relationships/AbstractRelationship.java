package geektrust.relationships;

import geektrust.Couple;
import geektrust.FamilyMember;
import geektrust.FamilyTree;
import geektrust.Gender;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractRelationship implements Relationship {
  protected final FamilyTree familyTree;

  public AbstractRelationship(FamilyTree familyTree) {
    this.familyTree = familyTree;
  }

  public abstract List<FamilyMember> get(String memberName);

  public List<String> getNames(String memberName) {
    return get(memberName).stream().map(member -> member.getName()).collect(Collectors.toList());
  }

  protected FamilyMember getFamilyMember(String memberName) {
    return familyTree.getFamilyMember(memberName);
  }

  protected List<FamilyMember> getChildrenOfGender(Couple couple, Gender gender) {
    return couple.getChildren().stream().filter(child -> child.getGender().equals(gender)).collect(Collectors.toList());
  }
}
