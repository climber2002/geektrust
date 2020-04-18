package geektrust;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static geektrust.Gender.FEMALE;
import static geektrust.Gender.MALE;
import static org.junit.jupiter.api.Assertions.*;

public class FamilyTreeTest {
  private final FamilyMember arthur = new FamilyMember("Arthur", MALE);
  private final FamilyMember margret = new FamilyMember("Margret", FEMALE);

  private FamilyTree familyTree;

  @BeforeEach
  public void before() {
    familyTree = new FamilyTree(arthur, margret);
  }

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

  @Test
  public void testAddChild_motherNotExists() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      familyTree.addChild("Nobody", "Percy", MALE);
    });
    assertEquals("Mother name Nobody doesn't exist", exception.getMessage());
  }

  @Test
  public void testAddChild_memberAlreadyExists() {
    familyTree.addChild("Margret", "Percy", MALE);

    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      familyTree.addChild("Margret", "Percy", MALE);
    });
    assertEquals("Family member Percy already exists", exception.getMessage());
  }
}
