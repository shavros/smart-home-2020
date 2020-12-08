package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;


public class SmartHomeReaderWriterJson implements SmartHomeReaderWriter{
    public SmartHome readHome(String jsonFileName) throws IOException {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get(jsonFileName)));
        return gson.fromJson(json, SmartHome.class);
    }
}
