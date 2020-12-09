package ru.sbt.mipt.oop;

import java.io.IOException;

/**
 * Класс реализует работу с умным домом.
 * Сначала из файла считываются параметра дома и записываются в класс умного дома.
 * Затем генерируется рандомное событие.
 * Потом оно обрабатывается классом обработки событий, в котором обновляется рандомное событие.
 */
public class Application {
    public static void main(String... args) throws IOException {
        SmartHomeReaderWriter reader = new SmartHomeReaderWriterJson();
        SmartHome smartHome = reader.readHome("smart-home-1.js");
        SensorEvent event = RandomEventGenerator.getNextSensorEvent();
        EventProcessorChooser.chooseEventProcessor(event, smartHome);
    }


}
