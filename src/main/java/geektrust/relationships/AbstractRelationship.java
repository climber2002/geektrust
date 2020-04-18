package geektrust.relationships;

import geektrust.Couple;
import geektrust.FamilyMember;
import geektrust.FamilyTree;
import geektrust.Gender;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static geektrust.Gender.MALE;

public abstract class AbstractRelationship implements Relationship {
  protected final FamilyTree familyTree;

  public AbstractRelationship(FamilyTree familyTree) {
    this.familyTree = familyTree;
  }

  public abstract List<FamilyMember> get(String memberName);

  public List<String> getNames(String memberName) {
    return get(memberName).stream().map(member -> member.getName()).collect(Collectors.toList());
  }

  protected FamilyMember getFamilyMember(String memberName) {
    return familyTree.getFamilyMember(memberName);
  }

  protected Optional<FamilyMember> getFatherOf(String memberName) {
    return this.getFamilyMember(memberName).getFather();
  }

  protected Optional<FamilyMember> getMotherOf(String memberName) {
    return this.getFamilyMember(memberName).getMother();
  }

  protected List<FamilyMember> getChildrenOf(Couple couple, Predicate<FamilyMember> childPredicate) {
    return couple.getChildren().stream().filter(child -> childPredicate.test(child)).collect(Collectors.toList());
  }

  protected List<FamilyMember> getSiblingsOf(FamilyMember member, Predicate<FamilyMember> siblingPredicate) {
    return member.getParents().map(parents -> parents.getChildren().stream()
        .filter(sibling -> !sibling.getName().equals(member.getName()))
        .filter(sibling -> siblingPredicate.test(sibling)).collect(Collectors.toList()))
      .orElse(Collections.emptyList());
  }

}
