package geektrust;

import org.junit.jupiter.api.Test;

import static geektrust.Gender.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FamilyMemberTest {

  @Test
  public void testCreation() {
    FamilyMember arthur = new FamilyMember("Arthur", MALE);
    assertEquals("Arthur", arthur.getName());
    assertEquals(MALE, arthur.getGender());
    assertFalse(arthur.getParents().isPresent());
  }
}
