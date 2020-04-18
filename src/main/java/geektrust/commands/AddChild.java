package geektrust.commands;

import geektrust.*;

public class AddChild extends AbstractCommand {
  private final String motherName;
  private final String childName;
  private final String childGenderName;

  public AddChild(String motherName, String childName, String childGenderName) {
    this.motherName = motherName;
    this.childName = childName;
    this.childGenderName = childGenderName;
  }

  @Override
  public String executeImpl(FamilyTree familyTree) {
    try {
      familyTree.addChild(motherName, childName, getChildGender());
      return "CHILD_ADDITION_SUCCEEDED";
    } catch (AddChildException ex) {
      return "CHILD_ADDITION_FAILED";
    }
  }

  public String getMotherName() {
    return motherName;
  }

  public String getChildName() {
    return childName;
  }

  public String getChildGenderName() {
    return childGenderName;
  }

  protected Gender getChildGender() {
    return Gender.valueOf(childGenderName.toUpperCase());
  }
}
