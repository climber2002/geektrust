package geektrust.relationships;

import geektrust.FamilyMember;
import geektrust.FamilyTree;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Sibling extends AbstractRelationship {
  public Sibling(FamilyTree familyTree) {
    super(familyTree);
  }

  @Override
  public List<FamilyMember> get(String memberName) {
    FamilyMember member = this.getFamilyMember(memberName);
    return getSiblingsOf(member);
  }
}
