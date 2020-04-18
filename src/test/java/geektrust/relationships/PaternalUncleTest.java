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
  public void testGetNameOfRelationships_hasPaternalUncle() {
    assertArrayEquals(new String[] { "Charlie", "Percy", "Ronald" },
      paternalUncle.getNameOfRelationships("Victoire").toArray(new String[0]));
  }

  @Test
  public void testGetNameOfRelationships_noParent() {
    assertTrue(paternalUncle.getNameOfRelationships("Arthur").isEmpty());
  }

  @Test
  public void testGetNameOfRelationships_fatherNoBrothers() {
    assertTrue(paternalUncle.getNameOfRelationships("Remus").isEmpty());
  }
}
