import java.util.Scanner;

// заполнение семейного дерева
public class FamilyTreeBuilder {

    private final FamilyTree familyTreeObject;

    public FamilyTreeBuilder(Scanner scanner, FamilyTree familyTree) {
        this.familyTreeObject = familyTree;
    }

    public void buildDefaultFamilyTree() {

        familyTreeObject.add("Sam");
        familyTreeObject.add("Mary");
        familyTreeObject.add("Alex");
        familyTreeObject.add("Joanna");
        familyTreeObject.add("Sandra");
        familyTreeObject.add("John");
        familyTreeObject.add("Julie");
        familyTreeObject.add("Susan");
        familyTreeObject.add("Tim");
        familyTreeObject.add("Nick");

        familyTreeObject.getMember("Sam").addChildren(familyTreeObject.getMember("Alex"));
        familyTreeObject.getMember("Mary").addChildren(familyTreeObject.getMember("Alex"));
        familyTreeObject.getMember("John").addChildren(familyTreeObject.getMember("Susan"));
        familyTreeObject.getMember("John").addChildren(familyTreeObject.getMember("Tim"));
        familyTreeObject.getMember("Julie").addChildren(familyTreeObject.getMember("Susan"));
        familyTreeObject.getMember("Julie").addChildren(familyTreeObject.getMember("Tim"));
        familyTreeObject.getMember("Alex").addChildren(familyTreeObject.getMember("Joanna"));
        familyTreeObject.getMember("Susan").addChildren(familyTreeObject.getMember("Joanna"));
        familyTreeObject.getMember("Joanna").addChildren(familyTreeObject.getMember("Sandra"));
        familyTreeObject.getMember("Nick").addChildren(familyTreeObject.getMember("Sandra"));
    }
}
