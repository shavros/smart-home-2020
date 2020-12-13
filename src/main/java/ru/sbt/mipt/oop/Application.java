package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.action.MessageSender;
import ru.sbt.mipt.oop.action.SMSMessageSender;
import ru.sbt.mipt.oop.event.RandomEventGenerator;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.home.SmartHome;
import ru.sbt.mipt.oop.home.SmartHomeReaderWriter;
import ru.sbt.mipt.oop.home.SmartHomeReaderWriterJson;
import ru.sbt.mipt.oop.processor.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Класс реализует работу с умным домом.
 * Сначала из файла считываются параметра дома и записываются в класс умного дома.
 * Затем генерируется рандомное событие.
 * Потом оно обрабатывается классом обработки событий, в котором обновляется рандомное событие.
 */
public class Application {
    public static void main(String... args) throws IOException {
        SmartHomeReaderWriter reader = new SmartHomeReaderWriterJson();
        SmartHome smartHome = reader.readHome("output.js");
        SensorEvent event = RandomEventGenerator.getNextSensorEvent();
        Collection<EventProcessor> eventProcessor = new ArrayList<>();
        MessageSender sender = new SMSMessageSender();
        eventProcessor.add(new DoorEventProcessor(smartHome));
        eventProcessor.add(new HallDoorEventProcessor(smartHome));
        eventProcessor.add(new LightEventProcessor(smartHome));
        eventProcessor.add(new AlarmActivateEventProcessor(smartHome));
        eventProcessor.add(new AlarmDeactivateEventProcessor(smartHome));
        while (event != null) {
            Chooser chooser =
                    new EventProcessorChooserDecorator(new EventProcessorChooser(eventProcessor), smartHome.getAlarm(), sender);
            chooser.chooseEventProcessor(event);
            event = RandomEventGenerator.getNextSensorEvent();
        }
    }


}
