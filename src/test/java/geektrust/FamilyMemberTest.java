package geektrust;

import org.junit.jupiter.api.Test;

import static geektrust.Gender.*;
import static org.junit.jupiter.api.Assertions.*;

public class FamilyMemberTest {

  private FamilyMember arthur = new FamilyMember("Arthur", MALE);

  @Test
  public void testCreation() {
    assertEquals("Arthur", arthur.getName());
    assertEquals(MALE, arthur.getGender());
    assertFalse(arthur.getParents().isPresent());
  }

  @Test
  public void testIsMarried_notMarried() {
    assertFalse(arthur.isMarried());
  }

  @Test
  public void testIsMarried_married() {
    FamilyMember margret = new FamilyMember("Margret", FEMALE);
    new Couple(arthur, margret);
    assertTrue(arthur.isMarried());
  }

  @Test
  public void testGetSpouse_notMarried() {
    assertFalse(arthur.getSpouse().isPresent());
  }

  @Test
  public void testGetSpouse_married() {
    FamilyMember margret = new FamilyMember("Margret", FEMALE);
    new Couple(arthur, margret);
    assertSame(arthur, margret.getSpouse().get());
    assertSame(margret, arthur.getSpouse().get());
  }
}
