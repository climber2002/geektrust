package geektrust.relationships;

import geektrust.FamilyTree;
import geektrust.FamilyTreeBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SisterInLawTest {
  private FamilyTree familyTree = new FamilyTreeBuilder().build();

  private Relationship sisterInLaw = new SisterInLaw(familyTree);

  @Test
  public void testGetNames_hasSpouseSisters() {
    assertArrayEquals(new String[] { "Lily" },
      sisterInLaw.getNames("Alice").toArray(new String[0]));
  }

  @Test
  public void testGetNames_hasSiblingWives() {
    assertArrayEquals(new String[] { "Flora", "Audrey" },
      sisterInLaw.getNames("Ronald").toArray(new String[0]));
  }

  @Test
  public void testGetNames_hasNoSpouseNorSiblings() {
    assertTrue(sisterInLaw.getNames("Aster").isEmpty());
  }
}
