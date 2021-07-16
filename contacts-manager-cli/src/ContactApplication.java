import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ContactApplication {

    public static void main(String[] args) {
    Path path = ContactReading.getPath("contacts-manager-cli", "src", "contacts.txt");
        System.out.println(path.toAbsolutePath());

        ContactReading.tryPrintContents(path);

//        List<String> test = new ArrayList<>();
//        test.add("Grady Griffin | 1231231234");
//        ContactAddAndDelete.tryWriteToFile(test, path);
    }

}
