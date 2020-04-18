package geektrust;

import org.junit.Test;

import java.util.List;

import static geektrust.Gender.*;
import static org.junit.Assert.*;

public class CoupleTest {
  private final FamilyMember arthur = new FamilyMember("Arthur", MALE);
  private final FamilyMember margret = new FamilyMember("Margret", FEMALE);

  private final FamilyMember bill = new FamilyMember("Bill", MALE);
  private final FamilyMember ginerva = new FamilyMember("Ginerva", FEMALE);

  @Test
  public void testCreation() {
    Couple couple = new Couple(arthur, margret);
    assertSame(arthur, couple.getMaleSpouse());
    assertSame(margret, couple.getFemaleSpouse());
    assertTrue(couple.getChildren().isEmpty());
  }

  @Test
  public void testCreation_reverseGender() {
    Couple couple = new Couple(margret, arthur);
    assertSame(arthur, couple.getMaleSpouse());
    assertSame(margret, couple.getFemaleSpouse());
    assertTrue(couple.getChildren().isEmpty());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCreation_sameGender() {
    new Couple(arthur, bill);
  }

  @Test
  public void testAddChild() {
    Couple couple = new Couple(arthur, margret);
    couple.addChild(bill);
    couple.addChild(ginerva);

    List<FamilyMember> children = couple.getChildren();
    assertArrayEquals(new FamilyMember[] { bill, ginerva }, children.toArray(new FamilyMember[0]));
    assertSame(couple, bill.getParents().get());
    assertSame(couple, ginerva.getParents().get());
  }
}
