import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ContactReading {

    public static List<String> readFromFile(Path path) throws IOException {
        return Files.readAllLines(path);
    }

    public static void tryPrintContents (Path path) {
        try {
            printFileContents(readFromFile(path));
        } catch (IOException e){
            System.out.println("Couldn't read file at " + path.toAbsolutePath());
        }
    }

    public static void printFileContents (List<String> contents) {
        for (String line : contents){
            System.out.println(line);
//            System.out.println(Arrays.toString(line.split(" \\| ")));

        }
    }

    public static Path getPath (String parentDirectory, String childDirectory, String fileName) {
        return Paths.get(parentDirectory, childDirectory, fileName);
    }

}
