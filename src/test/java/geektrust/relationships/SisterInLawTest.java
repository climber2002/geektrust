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
  public void testGetNameOfRelationships_hasSpouseSisters() {
    assertArrayEquals(new String[] { "Lily" },
      sisterInLaw.getNameOfRelationships("Alice").toArray(new String[0]));
  }

  @Test
  public void testGetNameOfRelationships_hasSiblingWives() {
    assertArrayEquals(new String[] { "Flora", "Audrey" },
      sisterInLaw.getNameOfRelationships("Ronald").toArray(new String[0]));
  }

  @Test
  public void testGetNameOfRelationships_hasNoSpouseNorSiblings() {
    assertTrue(sisterInLaw.getNameOfRelationships("Aster").isEmpty());
  }
}
