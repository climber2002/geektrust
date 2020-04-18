package geektrust.relationships;

import geektrust.FamilyMember;
import geektrust.FamilyTree;

import java.util.Collections;
import java.util.List;

import static geektrust.Gender.MALE;

public class Son extends AbstractRelationship {

  public Son(String memberName, FamilyTree familyTree) {
    super(memberName, familyTree);
  }

  @Override
  public List<FamilyMember> get() {
    return getFamilyMember().getCouple().map(couple -> getChildrenOfGender(couple, MALE))
                            .orElse(Collections.emptyList());
  }
}
