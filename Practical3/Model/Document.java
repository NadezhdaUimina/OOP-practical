package Model;

import Interface.TitleFormat;
import Items.Person;

public class Document<T extends Person> {
    TitleFormat format;
    String text;
    String path;
    T person;

    public Document(T person) {
        this.person = person;
    }

    public void setFormat(TitleFormat format) {
        this.format = format;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public <T extends Person> void save() {
        text = format.createString(person);
        Model.saveFile(text, this.path);

    }

}