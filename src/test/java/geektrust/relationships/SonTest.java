package geektrust.relationships;

import geektrust.FamilyTree;
import geektrust.FamilyTreeBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SonTest {
  private FamilyTree familyTree = new FamilyTreeBuilder().build();

  private Relationship son = new Son(familyTree);

  @Test
  public void testGetNameOfRelationships_hasSon() {
    assertArrayEquals(new String[] { "Bill", "Charlie", "Percy", "Ronald" },
      son.getNameOfRelationships("Margret").toArray(new String[0]));
  }

  @Test
  public void testGetNameOfRelationships_noChildren() {
    assertTrue(son.getNameOfRelationships("Charlie").isEmpty());
  }

  @Test
  public void testGetNameOfRelationships_onlyDaughters() {
    assertTrue(son.getNameOfRelationships("Audrey").isEmpty());
  }
}
