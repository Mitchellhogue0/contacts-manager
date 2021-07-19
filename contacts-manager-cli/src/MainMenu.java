import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {
    public static Scanner scanner = new Scanner(System.in);
    public static Path path = ContactReading.getPath("contacts-manager-cli", "src", "contacts.txt");


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
                ContactAdd.userAddContact();
                continueCheck();
                break;

            case "3":
                ContactIndexing.searchByName();
                continueCheck();
                break;
            case "4":
                try{
                    ContactDelete.deleteContact(ContactReading.readFromFile(MainMenu.path));
                } catch (IOException e){
                    System.out.println("Could not delete file at: " + path.toAbsolutePath());
                }
                continueCheck();
            case "5":
                try {
                    ContactEditing.tryEditFile(ContactReading.readFromFile(MainMenu.path));
                } catch (IOException e){
                    System.out.println("Could not read file at: " + path.toAbsolutePath());
                }
                continueCheck();
                break;
            case "6":
                System.exit(0);
                break;
            default:
                System.out.println("Error not an option.");
                homeScreen();

        }

    }
    public static void continueCheck(){
        System.out.println("\nWould you like to continue?");
        System.out.println("0 - yes");
        System.out.println("1 - no");
        String input = scanner.next();
        if (input.equalsIgnoreCase("0")){
            homeScreen();
        }
        else if(input.equalsIgnoreCase("1")){
            System.exit(0);
        }
        else{
            System.out.println("Error not an option.");
            continueCheck();
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
