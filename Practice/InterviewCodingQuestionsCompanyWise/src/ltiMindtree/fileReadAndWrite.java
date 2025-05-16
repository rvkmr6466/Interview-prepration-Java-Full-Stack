package ltiMindtree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fileReadAndWrite {
    /*
    Write a Java program that reads a file, replaces all occurrences of "java" with "JVM,"
    and writes the modified content back to the file.
     */
    public static void main(String[] args) {
        String filePath = "input.txt"; // Replace with the actual file path

        try {
            String fileContent = readFile(filePath);
            String modifiedContent = fileContent.replaceAll("java", "JVM");
            writeFile(filePath, modifiedContent);
            System.out.println("Replacement complete.");
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }

    private static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ( (line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }
        return content.toString();
    }

    private static void writeFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }
}
