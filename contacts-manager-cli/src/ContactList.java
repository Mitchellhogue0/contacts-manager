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
            String newNumber = contactArr[1].replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
            setContactList(numberOfContacts , new Contact(contactArr[0], newNumber));
            numberOfContacts++;
        }
        tryUpdatingList();
    }


    public static void tryUpdatingList () {
        List<String> placeholder = new ArrayList<>();
        for (Map.Entry<Integer, Contact> contact : contactList){
            placeholder.add(contact.getValue().getName() + " | " + contact.getValue().getNumber());
        }
        ContactEditing.writeToFileNoAppend(placeholder, MainMenu.path);
    }

}


