package geektrust.commands;

import geektrust.FamilyTree;
import geektrust.PersonAlreadyExistException;
import geektrust.PersonNotFoundException;

/**
 * This base command class process exceptions common to all commands, subclass commands should
 * implement executeImpl method
 */
public abstract class AbstractCommand implements Command {

  @Override
  public final String execute(FamilyTree familyTree) {
    try {
      return executeImpl(familyTree);
    } catch (PersonNotFoundException ex) {
      return "PERSON_NOT_FOUND";
    } catch (PersonAlreadyExistException ex) {
      return "PERSON_ALREADY_EXISTS";
    } catch (IllegalArgumentException ex) {
      return "INVALID_COMMAND";
    }
  }

  protected abstract String executeImpl(FamilyTree familyTree);
}
