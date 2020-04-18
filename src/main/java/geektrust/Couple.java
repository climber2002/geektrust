package geektrust;

import java.util.ArrayList;
import java.util.List;

public class Couple {
  private final FamilyMember maleSpouse;
  private final FamilyMember femaleSpouse;

  private final List<FamilyMember> children = new ArrayList<>();

  public Couple(FamilyMember spouse1, FamilyMember spouse2) {
    if(spouse1.getGender().equals(spouse2.getGender())) {
      throw new IllegalArgumentException("Same gender can't be couple");
    }
    if(spouse1.getGender().equals(Gender.MALE)) {
      this.maleSpouse = spouse1;
      this.femaleSpouse = spouse2;
    } else {
      this.maleSpouse = spouse2;
      this.femaleSpouse = spouse1;
    }
  }

  public FamilyMember getMaleSpouse() {
    return this.maleSpouse;
  }

  public FamilyMember getFemaleSpouse() {
    return this.femaleSpouse;
  }

  public List<FamilyMember> getChildren() {
    return new ArrayList(this.children);
  }

  public void addChild(FamilyMember child) {
    this.children.add(child);
    child.setParents(this);
  }
}
