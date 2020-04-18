package geektrust.commands;

import geektrust.FamilyTree;
import geektrust.relationships.*;

import java.util.List;
import java.util.stream.Collectors;

public class GetRelationship extends AbstractCommand {
  private final String memberName;
  private final String relationshipName;

  public GetRelationship(String memberName, String relationshipName) {
    this.memberName = memberName;
    this.relationshipName = relationshipName;
  }

  @Override
  public String executeImpl(FamilyTree familyTree) {
    Relationship relationship = getRelationship(familyTree);
    List<String> relationshipNames = relationship.getNameOfRelationships(memberName);
    if(relationshipNames.isEmpty()) {
      return "NONE";
    } else {
      return relationshipNames.stream().collect(Collectors.joining(" "));
    }
  }

  private Relationship getRelationship(FamilyTree familyTree) {
    Relationship relationship = null;
    switch (this.relationshipName) {
      case "Paternal-Uncle":
        relationship = new PaternalUncle(familyTree);
        break;
      case "Maternal-Uncle":
        relationship = new MaternalUncle(familyTree);
        break;
      case "Paternal-Aunt":
        relationship = new PaternalAunt(familyTree);
        break;
      case "Maternal-Aunt":
        relationship = new MaternalAunt(familyTree);
        break;
      case "Sister-In-Law":
        relationship = new SisterInLaw(familyTree);
        break;
      case "Brother-In-Law":
        relationship = new BrotherInLaw(familyTree);
        break;
      case "Son":
        relationship = new Son(familyTree);
        break;
      case "Daughter":
        relationship = new Daughter(familyTree);
        break;
      case "Siblings":
        relationship = new Sibling(familyTree);
        break;
      default:
        throw new IllegalArgumentException(String.format("Unknown relationship %s", this.relationshipName));
    }
    return relationship;
  }
}
