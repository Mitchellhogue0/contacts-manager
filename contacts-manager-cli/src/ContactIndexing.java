import com.sun.tools.javac.Main;

import java.util.Map;

public class ContactIndexing {

    public static void searchByName() {
        System.out.println("Enter a name or type 'exit': ");
        MainMenu.scanner.nextLine();
        String userInput = MainMenu.scanner.nextLine();
        if (userInput.equalsIgnoreCase("exit")){
            MainMenu.homeScreen();
        }
        boolean flag = false;
        for (Map.Entry<Integer, Contact> contactPair : ContactList.contactList) {
            if(contactPair.getValue().getName().toUpperCase().contains(userInput.toUpperCase())){
                System.out.println(contactPair.getValue().getName() + " | " + contactPair.getValue().getNumber());
                flag = true;
            }
        }
        if (!flag){
            System.out.println("Couldn't find anyone with that name");
            searchByName();
        }
    }
    public static void ifNameExists(String userInput){
        for (Map.Entry<Integer, Contact> contactPair : ContactList.contactList) {
            if(contactPair.getValue().getName().toUpperCase().equals(userInput.toUpperCase())){
                System.out.println("Contact for: " + contactPair.getValue().getName() + " already exists, did you want to override it?");
                if (yesNo()){
                    System.out.println("Enter new name: ");
                    MainMenu.scanner.nextLine();
                    String input5 = MainMenu.scanner.nextLine();
                    contactPair.getValue().setName(input5);
                    System.out.println("Enter new Number: ");
                    String input6 = MainMenu.scanner.nextLine();
                    contactPair.getValue().setNumber(input6);
                    System.out.println("Changed name and number to: " + input5 + " | " + input6);
                    ContactEditing.writeToFileNoAppend(MainMenu.path);
                    MainMenu.continueCheck();
                }
            }
        }
    }
    public static boolean yesNo(){
        System.out.println("0 - yes");
        System.out.println("1 - no");
        String nextInput = MainMenu.scanner.next();
        switch(nextInput){
            case "0":
                return true;
            case "1":
                System.out.println("Returning to main menu...");
                MainMenu.homeScreen();
            default:
                System.out.println("Error not an option.");
                return yesNo();
        }
    }
}
