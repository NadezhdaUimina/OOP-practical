package Model;

import Interface.TitleFormat;
import Items.Person;

public class JsonFormat implements TitleFormat {

    @Override
    public <T extends Person> String createString(T person) {
        return String.format("{\n" +
                "\"worker\" : {\n" +
                "\"age\":%d,\n" +
                "\"Firstname\":\"%s\",\n" +
                "\"Surname\":\"%s\"\n" +
                "}\n" +
                "}", person.getAge(), person.getFirstname(), person.getSurname());
    }
}