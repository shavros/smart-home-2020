package ru.sbt.mipt.oop;

import java.io.IOException;

public interface SmartHomeReaderWriter {
    public SmartHome readHome(String source) throws IOException;
}
