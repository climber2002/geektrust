package geektrust.commands;

import geektrust.*;

public class AddChild implements Command {
  private final String motherName;
  private final String childName;
  private final Gender childGender;

  public AddChild(String motherName, String childName, String childGender) {
    this.motherName = motherName;
    this.childName = childName;
    this.childGender = Gender.valueOf(childGender.toUpperCase());
  }

  @Override
  public String execute(FamilyTree familyTree) {
    try {
      familyTree.addChild(motherName, childName, childGender);
      return "CHILD_ADDITION_SUCCEEDED";
    } catch (AddChildException ex) {
      return "CHILD_ADDITION_FAILED";
    } catch (PersonNotFoundException ex) {
      return "PERSON_NOT_FOUND";
    } catch (PersonAlreadyExistException ex) {
      return "CHILD_ALREADY_EXISTS";
    }
  }
}
