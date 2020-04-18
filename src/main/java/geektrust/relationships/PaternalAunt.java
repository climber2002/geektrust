package geektrust.relationships;

import geektrust.FamilyMember;
import geektrust.FamilyTree;

import java.util.Collections;
import java.util.List;

import static geektrust.Gender.FEMALE;
import static geektrust.Gender.MALE;

public class PaternalAunt extends AbstractRelationship {
  public PaternalAunt(FamilyTree familyTree) {
    super(familyTree);
  }

  @Override
  public List<FamilyMember> get(String memberName) {
    return getFatherOf(memberName).map(father -> getSiblingsWithGender(father, FEMALE))
      .orElse(Collections.emptyList());
  }
}
