package geektrust.relationships;

import geektrust.FamilyMember;

import java.util.List;

public interface Relationship {
  /**
   * Get the relationship of the member whose name is memberName
   * @param memberName
   * @return
   */
  public List<FamilyMember> get(String memberName);

  /**
   * Same as get, but only return the names of all relationships
   * @param memberName
   * @return
   */
  public List<String> getNames(String memberName);
}
