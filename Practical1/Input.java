import java.util.Scanner;

public class Input {
    /*
     * getNumber -принимает данные от пользоватея для работы с меню
     */
    public int getNumber() {
        Scanner scanner = new Scanner(System.in);
        int num;
        System.out.print("Выбирете действие: ");
        num = scanner.nextInt();

        return num;
    }

    /*
     * getStaffInfo - принимает данные от пользователя для поска в БД
     */
    public String getStaffInfo() {
        Scanner scanner = new Scanner(System.in);
        String info;
        System.out.print("Введите данные поиска: ");
        info = scanner.nextLine();

        return info;
    }

}
