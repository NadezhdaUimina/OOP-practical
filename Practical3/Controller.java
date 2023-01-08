import Items.Worker;
import Model.*;


public class Controller {
    public static void run() {
        String pathJson = "Practical3/TestText/W1.json";
        String pathMd = "Practical3/TestText/W2.md";
        String pathXml = "Practical3/TestText/W3.xml";
        Worker w1 = new Worker(32, 35000, "Tom", "Bin");
        Document doc = new Document<Worker>(w1);
        doc.setFormat(new JsonFormat());
        doc.setPath(pathJson);
        doc.save();
        doc.setFormat(new MdFormat());
        doc.setPath(pathMd);
        doc.save();
        doc.setFormat(new XmlFormate());
        doc.setPath(pathXml);
        doc.save();
    }
}