package geektrust.relationships;

import geektrust.FamilyMember;
import geektrust.FamilyTree;

import java.util.Collections;
import java.util.List;

public class PaternalUncle extends AbstractRelationship {
  public PaternalUncle(FamilyTree familyTree) {
    super(familyTree);
  }

  @Override
  public List<FamilyMember> get(String memberName) {
    return getFatherOf(memberName).map(father -> getSiblingsOf(father, FamilyMember::isMale))
      .orElse(Collections.emptyList());
  }
}
