package geektrust.relationships;

import geektrust.FamilyMember;
import geektrust.FamilyTree;

import java.util.Collections;
import java.util.List;

import static geektrust.Gender.FEMALE;
import static geektrust.Gender.MALE;

public class MaternalAunt extends AbstractRelationship {
  public MaternalAunt(FamilyTree familyTree) {
    super(familyTree);
  }

  @Override
  public List<FamilyMember> get(String memberName) {
    return getMotherOf(memberName).map(mother -> getSiblingsWithGender(mother, FEMALE))
      .orElse(Collections.emptyList());
  }
}
