package geektrust;

import org.junit.Test;
import static geektrust.Gender.*;
import static org.junit.Assert.assertEquals;

public class FamilyMemberTest {

  @Test
  public void testCreation() {
    FamilyMember arthur = new FamilyMember("Arthur", MALE);
    assertEquals("Arthur", arthur.getName());
    assertEquals(MALE, arthur.getGender());
  }
}
