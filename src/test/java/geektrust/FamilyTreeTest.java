package geektrust;

import org.junit.Test;

import static geektrust.Gender.FEMALE;
import static geektrust.Gender.MALE;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class FamilyTreeTest {
  private final FamilyMember arthur = new FamilyMember("Arthur", MALE);
  private final FamilyMember margret = new FamilyMember("Margret", FEMALE);

  private final FamilyTree familyTree = new FamilyTree(arthur, margret);

  @Test
  public void testCreation() {
    Couple kingCouple = familyTree.getKingCouple();
    assertSame(arthur, kingCouple.getMaleSpouse());
    assertSame(margret, kingCouple.getFemaleSpouse());

    assertTrue(familyTree.hasFamilyMember("Arthur"));
    assertTrue(familyTree.hasFamilyMember("Margret"));
  }
}
