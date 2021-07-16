import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ContactAddAndDelete {

public static void tryWriteToFile (List<String> content, Path path) {
    try {
        Files.write(path, content, StandardOpenOption.APPEND);
    } catch (IOException e) {
        System.out.println("Could not write to file " + path.toAbsolutePath());
    }
}

}
