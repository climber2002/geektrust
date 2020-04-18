package geektrust;

import org.junit.Test;

import static geektrust.Gender.*;
import static org.junit.Assert.assertSame;

public class CoupleTest {
  private final FamilyMember arthur = new FamilyMember("Arthur", MALE);
  private final FamilyMember margret = new FamilyMember("Margret", FEMALE);

  private final FamilyMember bill = new FamilyMember("Bill", MALE);

  @Test
  public void testCreation() {
    Couple couple = new Couple(arthur, margret);
    assertSame(arthur, couple.getMaleSpouse());
    assertSame(margret, couple.getFemaleSpouse());
  }

  @Test
  public void testCreation_reverseGender() {
    Couple couple = new Couple(margret, arthur);
    assertSame(arthur, couple.getMaleSpouse());
    assertSame(margret, couple.getFemaleSpouse());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCreation_sameGender() {
    new Couple(arthur, bill);
  }
}
