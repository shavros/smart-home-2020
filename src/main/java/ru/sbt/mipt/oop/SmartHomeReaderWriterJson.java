package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;


public class SmartHomeReaderWriterJson implements SmartHomeReaderWriter{
    private Gson gson;
    private String json;

    public SmartHome readHome(String jsonFileName) {
        try {
            gson = new Gson();
            json = new String(Files.readAllBytes(Paths.get(jsonFileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gson.fromJson(json, SmartHome.class);
    }
}
