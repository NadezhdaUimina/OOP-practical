import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner;
    private final Menu menu;
    private final Search search;

    public UserInterface(Scanner scanner, Menu menu, FamilyTreeBuilder familyTreeBuilder, Search search) {
        this.scanner = scanner;
        this.menu = menu;
        this.search = search;
    }

    public void start() {

        while (true) {
            switch (menu.selectFunction()) {
                case "1": // показать всех членов генеалогического древа
                    search.showAllMembers();
                    break;
                case "2": // найти родителей
                    System.out.print("Введите имя: ");
                    search.findParents(scanner.nextLine());
                    break;
                case "3": // найти детей
                    System.out.print("Введите имя: ");
                    search.findChildren(scanner.nextLine());
                    break;
                case "4": // определите, являются ли два человека братьями и сестрами
                    System.out.println("Введите два имени: ");
                    search.areSiblings(scanner.nextLine(), scanner.nextLine());
                    break;
                case "0": // выход
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный ввод");
            }
        }
    }
}
