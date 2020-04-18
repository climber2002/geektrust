package geektrust.relationships;

import geektrust.FamilyMember;
import geektrust.FamilyTree;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static geektrust.Gender.MALE;

public class MaternalUncle extends AbstractRelationship {
  public MaternalUncle(FamilyTree familyTree) {
    super(familyTree);
  }

  @Override
  public List<FamilyMember> getRelationships(String memberName) {
    return getMotherOf(memberName).map(mother -> getSiblingsOf(mother, FamilyMember::isMale))
      .orElse(Collections.emptyList());
  }
}
