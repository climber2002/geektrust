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
  public void testGetNameOfRelationships_hasSpouseBrothers() {
    assertArrayEquals(new String[] { "Bill", "Charlie", "Percy", "Ronald" },
      brotherInLaw.getNameOfRelationships("Harry").toArray(new String[0]));
  }

  @Test
  public void testGetNameOfRelationships_hasSiblingHusbands() {
    assertArrayEquals(new String[] { "Ted" },
      brotherInLaw.getNameOfRelationships("Dominique").toArray(new String[0]));
  }

  @Test
  public void testGetNameOfRelationships_hasNoSpouseNorSiblings() {
    assertTrue(brotherInLaw.getNameOfRelationships("Aster").isEmpty());
  }
}
