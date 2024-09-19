package Day2CoreJava;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileInput {

    public static void main(String[] args) {
        String filePath = "sample.txt";
        String data = "Welcome to Java I/O handling!";

        // Writing content to a file
        writeToFile(filePath, data);

        // Reading file content using different methods
        System.out.println("1. Using BufferedReader and FileReader:");
        readUsingBufferedReader(filePath);

        System.out.println("\n2. Using FileInputStream:");
        readUsingFileInputStream(filePath);

        System.out.println("\n3. Using Scanner:");
        readUsingScanner(filePath);

        System.out.println("\n4. Using Files.readAllLines (NIO):");
        readUsingFilesReadAllLines(filePath);

        System.out.println("\n5. Using Files.lines (NIO) with Streams:");
        readUsingFilesLines(filePath);

        // Output the file's absolute path
        System.out.println("The file is located at: " + new File(filePath).getAbsolutePath());

        // Show basic file operations
        performFileOperations(filePath);
    }

    // Writing data to the file
    public static void writeToFile(String filePath, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
            System.out.println("File successfully written.");
        } catch (IOException e) {
            System.err.println("Unable to write to file: " + e.getMessage());
        }
    }

    // Method to read file using BufferedReader
    public static void readUsingBufferedReader(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file using BufferedReader: " + e.getMessage());
        }
    }

    // Method to read file using FileInputStream
    public static void readUsingFileInputStream(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                System.out.print((char) byteData);
            }
            System.out.println();
        } catch (IOException e) {
            System.err.println("Error reading file using FileInputStream: " + e.getMessage());
        }
    }

    // Method to read file using Scanner
    public static void readUsingScanner(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found using Scanner: " + e.getMessage());
        }
    }

    // Method to read file using Files.readAllLines (NIO)
    public static void readUsingFilesReadAllLines(String filePath) {
        try {
            Files.readAllLines(Paths.get(filePath)).forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error reading file using Files.readAllLines: " + e.getMessage());
        }
    }

    // Method to read file using Files.lines and Streams (NIO)
    public static void readUsingFilesLines(String filePath) {
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error reading file using Files.lines and Streams: " + e.getMessage());
        }
    }

    // File operations like renaming and deleting
    public static void performFileOperations(String filePath) {
        File file = new File(filePath);

        System.out.println("\nFile Details:");
        System.out.println("Exists: " + file.exists());
        System.out.println("Is Regular File: " + file.isFile());
        System.out.println("Is Directory: " + file.isDirectory());
        System.out.println("Readable: " + file.canRead());
        System.out.println("Writable: " + file.canWrite());
        System.out.println("File Path: " + file.getAbsolutePath());

        // Rename the file
        File renamedFile = new File("renamed_" + filePath);
        if (file.renameTo(renamedFile)) {
            System.out.println("File renamed successfully to: " + renamedFile.getName());
        } else {
            System.out.println("File renaming failed.");
        }

        // Delete the renamed file
        if (renamedFile.delete()) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}
