package geektrust.relationships;

import geektrust.FamilyTree;
import geektrust.FamilyTreeBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SiblingTest {
  private FamilyTree familyTree = new FamilyTreeBuilder().build();

  private Relationship sibling = new Sibling(familyTree);

  @Test
  public void testGetNames_hasSiblings() {
    assertArrayEquals(new String[] { "Bill", "Charlie", "Percy", "Ginerva" },
      sibling.getNames("Ronald").toArray(new String[0]));
  }

  @Test
  public void testGetNames_niSibling() {
    assertTrue(sibling.getNames("Remus").isEmpty());
  }
}
