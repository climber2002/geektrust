package geektrust.relationships;

import geektrust.FamilyMember;
import geektrust.FamilyTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static geektrust.Gender.FEMALE;
import static geektrust.Gender.MALE;

public class BrotherInLaw extends AbstractRelationship {
  public BrotherInLaw(FamilyTree familyTree) {
    super(familyTree);
  }

  @Override
  public List<FamilyMember> getRelationships(String memberName) {
    FamilyMember familyMember = getFamilyMember(memberName);
    List<FamilyMember> result = new ArrayList<>();
    result.addAll(getSpouseBrothers(familyMember));
    result.addAll(getHusbandsOfSiblings(familyMember));

    return result;
  }

  private List<FamilyMember> getSpouseBrothers(FamilyMember member) {
    return member.getSpouse().map(spouse -> getSiblingsOf(spouse, sibling -> sibling.getGender().equals(MALE)))
      .orElse(Collections.emptyList());
  }

  private List<FamilyMember> getHusbandsOfSiblings(FamilyMember member) {
    return getSiblingsOf(member, sibling -> sibling.getGender().equals(FEMALE) && sibling.isMarried())
      .stream().map(sibling -> sibling.getSpouse().get()).collect(Collectors.toList());
  }
}
