import java.util.Scanner;

public class Input {
    /**
     * getNumber -принимает данные от пользоватея для работы с меню
     * 
     * @return входные данные при работе с меню
     */
    public int getNumber() {
        Scanner scanner = new Scanner(System.in);
        int num;
        System.out.print("Выбирете действие: ");
        num = scanner.nextInt();
        return num;
    }

    /**
     * getStudentInfo - принимает данные от пользователя для поска в БД
     * 
     * @return входные данные при поике
     */
    public String getStudentInfo() {
        Scanner scanner = new Scanner(System.in);
        String info;
        System.out.print("Введите данные поиска: ");
        info = scanner.nextLine();
        return info;
    }


}
