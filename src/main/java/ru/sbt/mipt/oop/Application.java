package ru.sbt.mipt.oop;

import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class Application {


    public static void main(String... args) throws IOException {
        SmartHomeReaderWriter reader = new SmartHomeReaderWriterJson();
        SmartHome smartHome = reader.readHome("smart-home-1.js");
        SensorEvent event = RandomEventGenerator.getNextSensorEvent();
        chooseEventProcessor(event, smartHome);
    }

    private static void chooseEventProcessor(SensorEvent event, SmartHome smartHome) {
        while (event != null) {
            System.out.println("Got event: " + event);
            if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
                // событие от источника света
                LightEventProcessor processor = new LightEventProcessor(smartHome);
                processor.handleEvent(event);
            }
            if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
                // событие от двери
                DoorEventProcessor processor = new DoorEventProcessor(smartHome);
                processor.handleEvent(event);
            }
            if (event.getType() == DOOR_CLOSED) {
                for (Room room: smartHome.getRooms()) {
                    if (room.getName().equals("hall")) {
                        for (Door door: room.getDoors()) {
                            if (door.getId().equals(event.getObjectId())) {
                                HallDoorEventProcessor processor = new HallDoorEventProcessor(smartHome);
                                processor.handleEvent(event);
                            }
                        }
                    }
                }
            }
            event = RandomEventGenerator.getNextSensorEvent();
        }
    }
}
