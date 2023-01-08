package Interface;

import Items.Person;

public interface TitleFormat {
    public <T extends Person> String createString(T person);
}