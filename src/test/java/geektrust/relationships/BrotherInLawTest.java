package geektrust.relationships;

import geektrust.FamilyTree;
import geektrust.FamilyTreeBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrotherInLawTest {
  private FamilyTree familyTree = new FamilyTreeBuilder().build();

  private Relationship brotherInLaw = new BrotherInLaw(familyTree);

  @Test
  public void testGetNames_hasSpouseBrothers() {
    assertArrayEquals(new String[] { "Bill", "Charlie", "Percy", "Ronald" },
      brotherInLaw.getNames("Harry").toArray(new String[0]));
  }

  @Test
  public void testGetNames_hasSiblingHusbands() {
    assertArrayEquals(new String[] { "Ted" },
      brotherInLaw.getNames("Dominique").toArray(new String[0]));
  }

  @Test
  public void testGetNames_hasNoSpouseNorSiblings() {
    assertTrue(brotherInLaw.getNames("Aster").isEmpty());
  }
}
