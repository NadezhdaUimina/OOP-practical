import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException{
        Program p = new Program();
        p.program();
        FileChat f = new FileChat();
        f.saveToFile();
    }
}
