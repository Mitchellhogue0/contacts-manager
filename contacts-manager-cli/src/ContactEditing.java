import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ContactEditing {

    public static void tryEditFile (List<String> contents) {
        ContactList.contactList.clear();
        int numberOfContacts = 0;
        for (String line : contents){
            String[] contactArr = line.split(" \\| ");
            ContactList.setContactList(numberOfContacts , new Contact(contactArr[0], contactArr[1]));
            numberOfContacts++;
        }
        System.out.println("Enter the number of contact you would like to edit: ");
        for (Map.Entry<Integer, Contact> contact : ContactList.contactList){
            System.out.print(contact.getKey() + ": ");
            System.out.println(contact.getValue().getName() + " | " + contact.getValue().getNumber());
        }
        String input = MainMenu.scanner.next();
        System.out.println("Please select how you would like to edit: ");
        System.out.println("0: Edit name");
        System.out.println("1: Edit number");
        System.out.println("2: Edit both");
        System.out.println("3: Cancel");
        String input2 = MainMenu.scanner.next();
        switch (input2){
            case "0":
                System.out.println("Enter new name: ");
                MainMenu.scanner.nextLine();
                String input3 = MainMenu.scanner.nextLine();
                ContactList.contactList.get(Integer.parseInt(input)).getValue().setName(input3);
                System.out.println("Changed name to: " + input3);
                break;
            case "1":
                System.out.println("Enter new Number: ");
                MainMenu.scanner.nextLine();
                String input4 = MainMenu.scanner.nextLine();
                ContactList.contactList.get(Integer.parseInt(input)).getValue().setNumber(input4);
                System.out.println("Changed number to: " + input4);
                break;
            case "2":
                System.out.println("Enter new name: ");
                MainMenu.scanner.nextLine();
                String input5 = MainMenu.scanner.nextLine();
                ContactList.contactList.get(Integer.parseInt(input)).getValue().setName(input5);
                System.out.println("Enter new Number: ");
                String input6 = MainMenu.scanner.nextLine();
                ContactList.contactList.get(Integer.parseInt(input)).getValue().setNumber(input6);
                System.out.println("Changed name and number to: " + input5 + " | " + input6);
                break;
            case "3":
                System.out.println("Returning to main menu....");
                MainMenu.homeScreen();
                break;
            default:
                System.out.println("Error not an option.");
                tryEditFile(contents);
        }
        writeToFileNoAppend(MainMenu.path);
    }

    public static void writeToFileNoAppend (Path path) {
        List<String> placeholder = new ArrayList<>();
        for (Map.Entry<Integer, Contact> contact : ContactList.contactList){
            placeholder.add(contact.getValue().getName() + " | " + contact.getValue().getNumber());
        }
        try {
            Files.write(path, placeholder);
        } catch (IOException e) {
            System.out.println("Could not write to file " + path.toAbsolutePath());
        }
    }

}
