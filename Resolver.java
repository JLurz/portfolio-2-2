import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class Resolver {
    private static final String FOLDER_PREFIX = "Projekte/";

    /*
     * Gibt den inhalt der Startseiten als String zurück
     */
    public String loadFile(String path) throws FileNotFoundException, NullPointerException {
        StringBuilder fileContent = new StringBuilder();

        String absolutePath = Objects.requireNonNull(this.getClass().getClassLoader().getResource(FOLDER_PREFIX + path)).getPath();
        File file = new File(absolutePath);
        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {
            fileContent.append(reader.nextLine());
        }

        return fileContent.toString();
    }

    /*
     * Überprüft, dass die Datei gefunden wurde
     */
    public String getInhalt(String StartSeite) {
        try {
            return loadFile(StartSeite);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return StartSeite;
    }

}


