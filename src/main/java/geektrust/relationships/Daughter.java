package geektrust.relationships;

import geektrust.FamilyMember;
import geektrust.FamilyTree;

import java.util.Collections;
import java.util.List;

import static geektrust.Gender.FEMALE;
import static geektrust.Gender.MALE;

public class Daughter extends AbstractRelationship {
  public Daughter(String memberName, FamilyTree familyTree) {
    super(memberName, familyTree);
  }

  @Override
  public List<FamilyMember> get() {
    return getFamilyMember().getCouple().map(couple -> getChildrenOfGender(couple, FEMALE))
      .orElse(Collections.emptyList());
  }

}
