package geektrust;

import static geektrust.Gender.FEMALE;
import static geektrust.Gender.MALE;

public class FamilyTreeBuilder {
  private FamilyTree familyTree;

  public FamilyTree build() {
    FamilyMember king = new FamilyMember("Arthur", MALE);
    FamilyMember margret = new FamilyMember("Margret", FEMALE);
    this.familyTree = new FamilyTree(king, margret);

    buildSecondGeneration();
    buildThirdGeneration();
    buildFourthGeneration();
    return this.familyTree;
  }

  private void buildSecondGeneration() {
    familyTree.addChild("Margret", "Bill", MALE);
    familyTree.addChild("Margret", "Charlie", MALE);
    familyTree.addChild("Margret", "Percy", MALE);
    familyTree.addChild("Margret", "Ronald", MALE);
    familyTree.addChild("Margret", "Ginerva", FEMALE);

    familyTree.marry("Bill", "Flora", FEMALE);
    familyTree.marry("Percy", "Audrey", FEMALE);
    familyTree.marry("Ronald", "Helen", FEMALE);
    familyTree.marry("Ginerva", "Harry", MALE);
  }

  private void buildThirdGeneration() {
    familyTree.addChild("Flora", "Victoire", FEMALE);
    familyTree.addChild("Flora", "Dominique", FEMALE);
    familyTree.addChild("Flora", "Louis", MALE);
    familyTree.marry("Victoire", "Ted", MALE);

    familyTree.addChild("Audrey", "Molly", FEMALE);
    familyTree.addChild("Audrey", "Lucy", FEMALE);

    familyTree.addChild("Helen", "Rose", FEMALE);
    familyTree.addChild("Helen", "Hugo", MALE);
    familyTree.marry("Rose", "Malfoy", MALE);

    familyTree.addChild("Ginerva", "James", MALE);
    familyTree.addChild("Ginerva", "Albus", MALE);
    familyTree.addChild("Ginerva", "Lily", FEMALE);
    familyTree.marry("James", "Darcy", FEMALE);
    familyTree.marry("Albus", "Alice", FEMALE);
  }

  private void buildFourthGeneration() {
    familyTree.addChild("Victoire", "Remus", MALE);
    familyTree.addChild("Rose", "Draco", MALE);
    familyTree.addChild("Rose", "Aster", FEMALE);
    familyTree.addChild("Darcy", "William", MALE);
    familyTree.addChild("Alice", "Ron", FEMALE);
    familyTree.addChild("Alice", "Ginny", FEMALE);
  }
}
