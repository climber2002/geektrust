package geektrust;

import org.junit.Test;

import static geektrust.Gender.FEMALE;
import static geektrust.Gender.MALE;
import static org.junit.Assert.*;

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

  @Test
  public void testAddChild() {
    FamilyMember percy = familyTree.addChild("Margret", "Percy", MALE);
    assertEquals("Percy", percy.getName());
    assertEquals(MALE, percy.getGender());
    assertSame(arthur, percy.getFather().get());
    assertSame(margret, percy.getMother().get());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddChild_motherNotExists() {
    FamilyMember percy = familyTree.addChild("Nobody", "Percy", MALE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddChild_memberAlreadyExists() {
    familyTree.addChild("Margret", "Percy", MALE);
    familyTree.addChild("Margret", "Percy", MALE);
  }
}
