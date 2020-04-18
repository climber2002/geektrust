package geektrust.relationships;

import geektrust.FamilyTree;
import geektrust.FamilyTreeBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaternalAuntTest {

  private FamilyTree familyTree = new FamilyTreeBuilder().build();

  private Relationship paternalAunt = new PaternalAunt(familyTree);

  @Test
  public void testGetNames_hasPaternalUncle() {
    assertArrayEquals(new String[] { "Ginerva" },
      paternalAunt.getNames("Victoire").toArray(new String[0]));
  }

  @Test
  public void testGetNames_noParent() {
    assertTrue(paternalAunt.getNames("Arthur").isEmpty());
  }

  @Test
  public void testGetNames_fatherNoSisters() {
    assertTrue(paternalAunt.getNames("Remus").isEmpty());
  }
}
