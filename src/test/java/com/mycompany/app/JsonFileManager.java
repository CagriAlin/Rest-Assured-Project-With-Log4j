package com.mycompany.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JsonFileManager {

    public static Map<String, String> getAllJsonContentsByFileName() {
        // Map to store JSON contents with file names
        Map<String, String> jsonContentMap = new HashMap<>();

        try {
            // Specify the path to the resources folder
            String resourcesFolderPath = "src/test/resources";

            // Get all JSON files in the resources folder
            List<Path> jsonFiles = getAllJsonFiles(resourcesFolderPath);

            // Add each JSON file's name as the key and its content as the value to the map
            for (Path jsonFile : jsonFiles) {
                String fileName = jsonFile.getFileName().toString();
                String content = readJsonFile(jsonFile);
                jsonContentMap.put(fileName, content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonContentMap;
    }

    // Helper method to get all JSON files in a folder
    private static List<Path> getAllJsonFiles(String folderPath) throws IOException {
        try (Stream<Path> fileStream = Files.walk(Paths.get(folderPath))) {
            return fileStream
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().toLowerCase().endsWith(".json"))
                    .collect(Collectors.toList());
        }
    }

    // Helper method to read the content of a JSON file
    private static String readJsonFile(Path filePath) throws IOException {
        byte[] bytes = Files.readAllBytes(filePath);
        return new String(bytes);
    }
}
