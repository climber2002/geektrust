package geektrust.relationships;

import geektrust.FamilyMember;
import geektrust.FamilyTree;

import java.util.Collections;
import java.util.List;

import static geektrust.Gender.MALE;

public class Son extends AbstractRelationship {

  public Son(FamilyTree familyTree) {
    super(familyTree);
  }

  @Override
  public List<FamilyMember> get(String memberName) {
    return getFamilyMember(memberName).getCouple().map(couple -> getChildrenOfGender(couple, MALE))
                            .orElse(Collections.emptyList());
  }
}
