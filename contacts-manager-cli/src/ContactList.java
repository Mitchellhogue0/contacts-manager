import java.util.*;

public class ContactList {

    public static List<Map.Entry<Integer, Contact>> contactList = new ArrayList<>();



    public static void setContactList ( int index, Contact contact) {
        contactList.add(new AbstractMap.SimpleEntry<>(index, contact));

    }


    public static void getContacts(List<String> contents){
        contactList.clear();
        int numberOfContacts = 0;
        for (String line : contents){
            String[] contactArr = line.split(" \\| ");
            setContactList(numberOfContacts , new Contact(contactArr[0], contactArr[1]));
            numberOfContacts++;
        }
    }


    public static void tryUpdatingList () {
        for (Map.Entry<Integer, Contact> contact : contactList){
            System.out.println(contact.getValue().getName());
            List<String> placeholder = new ArrayList<>();
            placeholder.add(contact.getValue().getName() + " | " + contact.getValue().getNumber());
            ContactAdd.tryWriteToFile(placeholder, MainMenu.path);
            System.out.println(contactList);
        }
    }

}


