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
  public void testGetNameOfRelationships_hasPaternalUncle() {
    assertArrayEquals(new String[] { "Ginerva" },
      paternalAunt.getNameOfRelationships("Victoire").toArray(new String[0]));
  }

  @Test
  public void testGetNameOfRelationships_noParent() {
    assertTrue(paternalAunt.getNameOfRelationships("Arthur").isEmpty());
  }

  @Test
  public void testGetNameOfRelationships_fatherNoSisters() {
    assertTrue(paternalAunt.getNameOfRelationships("Remus").isEmpty());
  }
}
