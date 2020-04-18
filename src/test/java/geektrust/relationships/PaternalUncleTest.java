package geektrust.relationships;

import geektrust.FamilyTree;
import geektrust.FamilyTreeBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaternalUncleTest {
  private FamilyTree familyTree = new FamilyTreeBuilder().build();

  private Relationship paternalUncle = new PaternalUncle(familyTree);

  @Test
  public void testGetNames_hasPaternalUncle() {
    assertArrayEquals(new String[] { "Charlie", "Percy", "Ronald" },
      paternalUncle.getNames("Victoire").toArray(new String[0]));
  }

  @Test
  public void testGetNames_noParent() {
    assertTrue(paternalUncle.getNames("Arthur").isEmpty());
  }

  @Test
  public void testGetNames_fatherNoBrothers() {
    assertTrue(paternalUncle.getNames("Remus").isEmpty());
  }
}
