import java.util.List;
import java.util.Map;

public class ContactDelete {
    public static void deleteContact(List<String> contents){
        ContactList.contactList.clear();
        int numberOfContacts = 0;
        for (String line : contents){
            String[] contactArr = line.split(" \\| ");
            ContactList.setContactList(numberOfContacts , new Contact(contactArr[0], contactArr[1]));
            numberOfContacts++;
        }
        System.out.println("Enter the number of contact you would like to delete: ");

        for (Map.Entry<Integer, Contact> contact : ContactList.contactList){
            System.out.print(contact.getKey() + ": ");
            System.out.println(contact.getValue().getName() + " | " + contact.getValue().getNumber());
        }
        String input = MainMenu.scanner.next();
        System.out.println("Are you sure you want to delete: ");
        System.out.println(ContactList.contactList.get(Integer.parseInt(input)).getValue().getName() + " | " + ContactList.contactList.get(Integer.parseInt(input)).getValue().getNumber());
        System.out.println("0 - yes");
        System.out.println("1 - no");
        String choice = MainMenu.scanner.next();
        switch(choice) {
            case "0": ContactList.contactList.remove(Integer.parseInt(input));
            break;
            case "1":
                System.out.println("Returning to main menu....");
                MainMenu.homeScreen();
                break;
            default:
                System.out.println("Error not an option.");
                deleteContact(contents);
        }
        System.out.println("Contact deleted successfully....");
        ContactEditing.writeToFileNoAppend(MainMenu.path);

    }


}

