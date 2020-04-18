package geektrust.relationships;

import geektrust.FamilyTree;
import geektrust.FamilyTreeBuilder;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DaughterTest {
  private FamilyTree familyTree = new FamilyTreeBuilder().build();

  private AbstractRelationship daughter;

  @Test
  public void testGetNames_hasDaughter() {
    this.daughter = new Daughter("Margret", familyTree);
    assertArrayEquals(new String[] { "Ginerva" }, daughter.getNames().toArray(new String[0]));
  }

  @Test
  public void testGetNames_noChildren() {
    this.daughter = new Daughter("Charlie", familyTree);
    assertTrue(daughter.getNames().isEmpty());
  }

  @Test
  public void testGetNames_noDaughters() {
    this.daughter = new Daughter("Ted", familyTree);
    System.out.println(Arrays.toString(daughter.getNames().toArray(new String[0])));
    assertTrue(daughter.getNames().isEmpty());
  }
}
