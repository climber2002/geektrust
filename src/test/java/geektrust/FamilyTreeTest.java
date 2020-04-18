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
    assertEquals("Member name Nobody doesn't exist", exception.getMessage());
  }

  @Test
  public void testAddChild_memberAlreadyExists() {
    familyTree.addChild("Margret", "Percy", MALE);

    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      familyTree.addChild("Margret", "Percy", MALE);
    });
    assertEquals("Family member Percy already exists", exception.getMessage());
  }

  @Test
  public void testAddChild_addFromFather() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      familyTree.addChild("Arthur", "Percy", MALE);
    });
    assertEquals("The name Arthur is not female", exception.getMessage());
  }

  @Test
  public void testMarry() {
    familyTree.addChild("Margret", "Percy", MALE);

    Couple couple = familyTree.marry("Percy", "Audrey", FEMALE);
    FamilyMember audrey = couple.getFemaleSpouse();
    assertEquals("Audrey", audrey.getName());
    assertEquals(FEMALE, audrey.getGender());
    assertSame("Percy", audrey.getSpouse().get().getName());
  }

  @Test
  public void testMarry_memberToMarryNotExist() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      familyTree.marry("Nobody", "Audrey", FEMALE);
    });
    assertEquals("Member name Nobody doesn't exist", exception.getMessage());
  }

  @Test
  public void testMarry_spouseAlreadyExist() {
    familyTree.addChild("Margret", "Percy", MALE);
    familyTree.addChild("Margret", "Audrey", MALE);

    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      familyTree.marry("Percy", "Audrey", FEMALE);
    });
    assertEquals("Family member Audrey already exists", exception.getMessage());
  }

  @Test
  public void testMarry_sameGender() {
    familyTree.addChild("Margret", "Percy", MALE);

    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      familyTree.marry("Percy", "Audrey", MALE);
    });
    assertEquals("Same gender can't be couple", exception.getMessage());
  }
}
