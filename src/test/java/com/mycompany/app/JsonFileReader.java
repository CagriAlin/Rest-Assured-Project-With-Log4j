package com.mycompany.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileReader {

    public static String readJsonFile(String filePath) {
        String content = "";

        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    public static String getJsonContent() {
        // JSON dosyasının bulunduğu yolu belirtin
        String filePath = "src/test/resources/jsons/example.json";

        // JSON dosyasını oku
        String content = readJsonFile(filePath);

        // Çift tırnak içinde olmayan sayıların önündeki boşlukları kaldır
        content = content.replaceAll("(?<!\")\\s*(\\d+)\\s*(?!\")", "$1");

        // Çift tırnak öncesi ve sonrasındaki boşlukları kaldır
        content = content.replaceAll("\\s*\"\\s*", "\"");

        // Köşeli parantez öncesi ve sonrasındaki boşlukları kaldır
        content = content.replaceAll("\\s*\\[\\s*", "[") .replaceAll("\\s*\\]\\s*", "]");


        return content;
    }

}
