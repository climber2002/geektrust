package geektrust.relationships;

import geektrust.FamilyMember;
import geektrust.FamilyTree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
