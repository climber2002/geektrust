package geektrust;

import org.junit.Test;
import static geektrust.Gender.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FamilyMemberTest {

  @Test
  public void testCreation() {
    FamilyMember arthur = new FamilyMember("Arthur", MALE);
    assertEquals("Arthur", arthur.getName());
    assertEquals(MALE, arthur.getGender());
    assertFalse(arthur.getParents().isPresent());
  }
}
