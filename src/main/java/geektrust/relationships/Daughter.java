package geektrust.relationships;

import geektrust.FamilyMember;
import geektrust.FamilyTree;

import java.util.Collections;
import java.util.List;

import static geektrust.Gender.FEMALE;

public class Daughter extends AbstractRelationship {
  public Daughter(FamilyTree familyTree) {
    super(familyTree);
  }

  @Override
  public List<FamilyMember> get(String memberName) {
    return getFamilyMember(memberName).getCouple().map(couple -> getChildrenOfGender(couple, FEMALE))
      .orElse(Collections.emptyList());
  }

}
