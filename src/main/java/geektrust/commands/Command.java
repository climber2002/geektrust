package geektrust.commands;

import geektrust.FamilyTree;

public interface Command {
  public String execute(FamilyTree familyTree);
}
