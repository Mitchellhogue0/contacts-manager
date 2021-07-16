import java.util.Map;

public class ContactIndexing {
    public static void main(String[] args) {

    }

    public static void searchByName() {
        System.out.println("Enter a name: ");
        MainMenu.scanner.nextLine();
        String userInput = MainMenu.scanner.nextLine();
        boolean flag = false;
        for (Map.Entry<Integer, Contact> contactPair : ContactList.contactList) {
            if(contactPair.getValue().getName().toUpperCase().contains(userInput.toUpperCase())){
                System.out.println(contactPair.getValue().getName() + " | " + contactPair.getValue().getNumber());
                flag = true;
            }
        }
        if (!flag){
            System.out.println("Couldn't find anyone with that name");
        }
    }
}
