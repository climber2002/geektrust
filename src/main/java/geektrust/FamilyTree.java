package geektrust;

import java.util.HashMap;
import java.util.Map;

public class FamilyTree {
  private final Couple kingCouple;
  private final Map<String, FamilyMember> familyMembers = new HashMap<>();

  public FamilyTree(FamilyMember king, FamilyMember queen) {
    this.kingCouple = new Couple(king, queen);
    addFamilyMember(king);
    addFamilyMember(queen);
  }

  public Couple getKingCouple() {
    return this.kingCouple;
  }

  public boolean hasFamilyMember(String name) {
    return familyMembers.containsKey(name);
  }

  private void addFamilyMember(FamilyMember familyMember) {
    if(hasFamilyMember(familyMember.getName())) {
      throw new IllegalArgumentException(String.format("Family member %s already exists", familyMember.getName()));
    }

    this.familyMembers.put(familyMember.getName(), familyMember);
  }
}
