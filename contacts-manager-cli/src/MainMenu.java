import java.io.IOException;

public class MainMenu {
    public static void main(String[] args) {
       try{
           ContactList.getContacts(ContactReading.readFromFile(ContactReading.getPath("contacts-manager-cli", "src", "contacts.txt")));
       } catch(IOException e){
           System.out.println("Couldn't get contacts at " + ContactReading.getPath("contacts-manager-cli", "src", "contacts.txt").toAbsolutePath());
       }
    }


}
