import java.util.*;

public class ContactList {

    public static List<Map.Entry<Integer, Contact>> contactList = new ArrayList<>();



    public static void setContactList ( int index, Contact contact) {
        contactList.add(new AbstractMap.SimpleEntry<>(index, contact));

    }


//    public static void nothing () {
//        Contact jack = new Contact("Jack Blank", "1231231234");
//        Contact jane = new Contact("Jane Doe", "1231231234");
//        Contact sam = new Contact("Sam Space", "1231231234");
//        setContactList("1", jack);
//        setContactList("2", jane);
//        setContactList("3", sam);
//    }
    public static void getContacts(List<String> contents){
        int numberOfContacts = 0;
        for (String line : contents){
            String[] contactArr = line.split(" \\| ");
            setContactList(numberOfContacts , new Contact(contactArr[0], contactArr[1]));
            numberOfContacts++;
        }
        for (Map.Entry<Integer, Contact> contact : contactList){
            System.out.println(contact.getKey());
            System.out.println(contact.getValue().getName());
            System.out.println(contact.getValue().getNumber());


        }

    }
//    public static void readContacts()


    public static void tryUpdatingList () {
        for (Map.Entry<Integer, Contact> contact : contactList){
            System.out.println(contact.getValue().getName());
            List<String> placeholder = new ArrayList<>();
            placeholder.add(contact.getValue().getName() + " | " + contact.getValue().getNumber());
            ContactAddAndDelete.tryWriteToFile(placeholder,  ContactReading.getPath("contacts-manager-cli", "src", "contacts.txt"));
        }
    }


    public static void main(String[] args) {
//        nothing();
        tryUpdatingList();
    }
}


