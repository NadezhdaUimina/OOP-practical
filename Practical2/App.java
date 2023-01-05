import java.util.Scanner;

/**
 *
 * @author Roope
 */
public class App {

    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);

        FamilyTreeBuilder familyTreeBuilder = new FamilyTreeBuilder(scanner, familyTree);
        familyTreeBuilder.buildDefaultFamilyTree();

        Search search = new Search(familyTree);

        UserInterface userInterface = new UserInterface(scanner, menu, familyTreeBuilder,
                search);
        userInterface.start();
    }
}
