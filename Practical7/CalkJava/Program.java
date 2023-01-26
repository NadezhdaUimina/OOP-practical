package CalkJava;

public class Program {
    public static void main(String[] args) {
        View v = new View();
        Presenter p = new Presenter(v);
        p.buttonStart();
    }
}