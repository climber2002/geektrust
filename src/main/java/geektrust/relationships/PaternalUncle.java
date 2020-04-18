package geektrust.relationships;

import geektrust.Couple;
import geektrust.FamilyMember;
import geektrust.FamilyTree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static geektrust.Gender.MALE;

public class PaternalUncle extends AbstractRelationship {
  public PaternalUncle(FamilyTree familyTree) {
    super(familyTree);
  }

  @Override
  public List<FamilyMember> get(String memberName) {
    return this.getFatherOf(memberName).map(father ->
      this.getSiblingsOf(father).stream().filter(sibling ->
        sibling.getGender().equals(MALE)).collect(Collectors.toList()))
      .orElse(Collections.emptyList());

  }

  private Optional<Couple> getParentsOfFather(String memberName) {
    return getFatherOf(memberName).flatMap(father -> father.getParents());
  }
}
