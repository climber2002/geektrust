package geektrust;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FamilyTreeBuilderTest {
  private final FamilyTree familyTree = new FamilyTreeBuilder().build();

  @Test
  public void testBuild_firstGeneration() {
    assertKing("Arthur");
    assertQueen("Margret");
  }

  @Test
  public void testBuild_secondGeneration() {
    assertParentsChildren("Arthur", "Margret",
      new String[] { "Bill", "Charlie", "Percy", "Ronald", "Ginerva" });
  }

  @Test
  public void testBuild_thirdGeneration() {
    assertParentsChildren("Bill", "Flora",
      new String[] { "Victoire", "Dominique", "Louis" });
    assertParentsChildren("Percy", "Audrey", new String[] { "Molly", "Lucy" });
    assertParentsChildren("Ronald", "Helen", new String[] { "Rose", "Hugo" });
    assertParentsChildren("Harry", "Ginerva",
      new String[] { "James", "Albus", "Lily" });
  }

  @Test
  public void testBuild_fourthGeneration() {
    assertParentsChildren("Ted", "Victoire", new String[] { "Remus" });
    assertParentsChildren("Malfoy", "Rose", new String[] { "Draco", "Aster" });
    assertParentsChildren("James", "Darcy", new String[] { "William" });
    assertParentsChildren("Albus", "Alice", new String[] { "Ron", "Ginny" });
  }

  private void assertKing(String kingName) {
    assertEquals(kingName, familyTree.getKingCouple().getMaleSpouse().getName());
  }

  private void assertQueen(String queenName) {
    assertEquals(queenName, familyTree.getKingCouple().getFemaleSpouse().getName());
  }

  private void assertParentsChildren(String fatherName, String motherName, String[] childrenName) {
    FamilyMember father = familyTree.fetchFamilyMember(fatherName).get();
    Couple parents = father.getCouple().get();
    assertEquals(motherName, parents.getFemaleSpouse().getName());

    assertArrayEquals(childrenName, parents.getChildren().stream().map(member -> member.getName()).toArray());
  }
}
