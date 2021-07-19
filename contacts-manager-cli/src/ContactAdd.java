import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ContactAdd {

public static void tryWriteToFile (List<String> content, Path path) {
    try {
        Files.write(path, content, StandardOpenOption.APPEND);
    } catch (IOException e) {
        System.out.println("Could not write to file " + path.toAbsolutePath());
    }
}

public static void userAddContact () {
    System.out.println("Enter name of contact or type 'exit': ");
    MainMenu.scanner.nextLine();
   String userName = MainMenu.scanner.nextLine();

    if (userName.equalsIgnoreCase("exit")){
        MainMenu.homeScreen();
    }
    ContactIndexing.ifNameExists(userName);
    System.out.println("Enter contact's number: ");
    String userNumber = MainMenu.scanner.nextLine();


    List<String> newContact = new ArrayList<>();
    newContact.add(userName + " | " + userNumber);
    tryWriteToFile(newContact, MainMenu.path);
    System.out.println("Contact added successfully... ");

    try {
        ContactList.getContacts(ContactReading.readFromFile(MainMenu.path));
    } catch (IOException e){
        System.out.println("Couldn't update file at " + MainMenu.path.toAbsolutePath());
    }
}

public static void writeNewContact () {

}
}
