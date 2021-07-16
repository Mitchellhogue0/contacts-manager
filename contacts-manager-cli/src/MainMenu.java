import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {
    public static Scanner scanner = new Scanner(System.in);
    public static Path path = ContactReading.getPath("contacts-manager-cli", "src", "contacts.txt");

    public static void main(String[] args) {
       initSetContacts();
       homeScreen();


    }


    public static void homeScreen() {
        System.out.println("Welcome!");
        System.out.println("1. View Contacts");
        System.out.println("2: Add a new contact");
        System.out.println("3. Search by contact name");
        System.out.println("4. Delete an existing contact");
        System.out.println("5. Edit an existing contact");
        System.out.println("6. Exit");
        System.out.println("Enter an option: ");
        chooseHomeScreen();
    }

    public static void chooseHomeScreen () {
        String choice = scanner.next();
        switch (choice){
            case "1":
                try {
                    ContactReading.printFileContents(ContactReading.readFromFile(path));
                } catch (IOException e){
                    System.out.println("Couldn't print contents at " + path.toAbsolutePath());
                }
                continueCheck();
                break;

            case "2":
                ContactAddAndDelete.userAddContact();
                continueCheck();
                break;

            case "3":
                ContactIndexing.searchByName();
                continueCheck();
                break;
            case "log":
                for (Map.Entry<Integer, Contact> contact : ContactList.contactList){
                    System.out.println(contact);
                }
                continueCheck();
                break;
        }

    }
    public static void continueCheck(){
        System.out.println("Would you like to continue? y/n");
        String input = scanner.next();
        if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")){
            homeScreen();
        }
        else {
            return;
        }
    }


    public static void initSetContacts() {
        try{
            ContactList.getContacts(ContactReading.readFromFile(path));
        } catch(IOException e){
            System.out.println("Couldn't get contacts at " + path.toAbsolutePath());
        }
    }


}
