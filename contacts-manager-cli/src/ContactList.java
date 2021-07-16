import java.util.*;

public class ContactList {

    public static List<Map.Entry<String, Contact>> contactList = new ArrayList<>();


    public static void setContactList ( String name, Contact contact) {
        contactList.add(new AbstractMap.SimpleEntry<>(name, contact));

    }


    public static void nothing () {
        Contact jack = new Contact("Jack Blank", "1231231234");
        Contact jane = new Contact("Jane Doe", "1231231234");
        Contact sam = new Contact("Sam Space", "1231231234");
        setContactList("1", jack);
        setContactList("2", jane);
        setContactList("3", sam);
    }

    public static void tryUpdatingList () {
        for (Map.Entry<String, Contact> contact : contactList){
            System.out.println(contact.getValue().getName());
            List<String> placeholder = new ArrayList<>();
            placeholder.add(contact.getValue().getName() + " | " + contact.getValue().getNumber());
            ContactAddAndDelete.tryWriteToFile(placeholder,  ContactReading.getPath("contacts-manager-cli", "src", "contacts.txt"));
        }
    }


    public static void main(String[] args) {
        nothing();
        tryUpdatingList();
    }
}


