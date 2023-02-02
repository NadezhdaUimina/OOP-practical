import java.util.ArrayList;

public class Phonebook {
    private static ArrayList<Contact> phonebook = new ArrayList<>();

    public static ArrayList<Contact> getPhonebook() {
        return phonebook;
    }

    public static void addContacts(Contact contact) {
        phonebook.add(contact);
    }
}