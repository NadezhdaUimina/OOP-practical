import java.util.Scanner;

public class Menu {

    private final Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public String selectFunction() {
        System.out.print("Выберите действие:\n"
                + "1. показать всех членов генеалогического древа\n"
                + "2. найти родителей\n"
                + "3. найти детей\n"
                + "4. определите, являются ли два человека братьями и сестрами\n"
                + "--------------------------------------\n"
                + "0. Выход\n");
        return scanner.nextLine();
    }
}
