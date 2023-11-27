package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class PythonRunner {
    public static String runCode() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("python3", "src/main/resources/test_script.py");
        Process process = processBuilder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder returnLine = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            returnLine.append(line);
        }

        return returnLine.toString();
    }

    public static void createPythonFile(String content) {
        String[] linesArray = content.split("\\n");
        List<String> lines = Arrays.asList(linesArray);
        String filePath = "src/main/resources/test_script.py";

        // Specify the content to be written to the file
        try {
            Files.deleteIfExists(Path.of(filePath));
        } catch (IOException e) {
            // Handle potential IOException
            e.printStackTrace();
        }
        // Create the file and write content
        try {
            Path file = Path.of(filePath);
            Files.createFile(file);

            // Write the content to the file
            Files.write(file, lines, StandardOpenOption.WRITE);
            System.out.println("File created and populated successfully.");

        } catch (IOException e) {
            // Handle potential IOException
            e.printStackTrace();
        }
    }
}
