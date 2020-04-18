package geektrust.relationships;

import geektrust.FamilyMember;
import geektrust.FamilyTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static geektrust.Gender.FEMALE;
import static geektrust.Gender.MALE;

public class SisterInLaw extends AbstractRelationship {
  public SisterInLaw(FamilyTree familyTree) {
    super(familyTree);
  }

  @Override
  public List<FamilyMember> get(String memberName) {
    FamilyMember familyMember = getFamilyMember(memberName);
    List<FamilyMember> result = new ArrayList<>();
    result.addAll(getSpouseSisters(familyMember));
    result.addAll(getWivesOfSiblings(familyMember));

    return result;
  }

  private List<FamilyMember> getSpouseSisters(FamilyMember member) {
    return member.getSpouse().map(spouse -> getSiblingsOf(spouse, sibling -> sibling.getGender().equals(FEMALE)))
      .orElse(Collections.emptyList());
  }

  private List<FamilyMember> getWivesOfSiblings(FamilyMember member) {
    return getSiblingsOf(member, sibling -> sibling.getGender().equals(MALE) && sibling.isMarried())
      .stream().map(sibling -> sibling.getSpouse().get()).collect(Collectors.toList());
  }
}
