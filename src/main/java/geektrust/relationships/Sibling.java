package geektrust.relationships;

import geektrust.FamilyMember;
import geektrust.FamilyTree;

import java.util.List;

public class Sibling extends AbstractRelationship {
  public Sibling(FamilyTree familyTree) {
    super(familyTree);
  }

  @Override
  public List<FamilyMember> get(String memberName) {
    FamilyMember member = this.getFamilyMember(memberName);
    return getSiblingsOf(member, sibling -> true);
  }
}
