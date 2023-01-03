import java.io.IOException;

public class ModelApp {
    public void app() throws IOException {
        Interface view = new Interface();
        view.info();
        Input in = new Input();
        int number = in.getNumber();
        Infrastructure infrastructure = new Infrastructure();
        if (number == 1) {
            infrastructure.allStaff();
        }
        if (number == 2) {
            String info = in.getStaffInfo();
            infrastructure.search(info);
        }
        if (number == 3) {
            infrastructure.saveToFile();
        }
    }
}
