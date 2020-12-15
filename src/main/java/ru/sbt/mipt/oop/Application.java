package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.EventHandler;
import com.coolcompany.smarthome.events.SensorEventsManager;
import ru.sbt.mipt.oop.action.MessageSender;
import ru.sbt.mipt.oop.action.SMSMessageSender;
import ru.sbt.mipt.oop.event.RandomEventGenerator;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.home.SmartHome;
import ru.sbt.mipt.oop.home.SmartHomeReaderWriter;
import ru.sbt.mipt.oop.home.SmartHomeReaderWriterJson;
import ru.sbt.mipt.oop.processor.*;
import ru.sbt.mipt.oop.remote.AllLightsTurnOffCommand;
import ru.sbt.mipt.oop.remote.SmartHomeRemoteController;

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
        SmartHomeRemoteController rc = new SmartHomeRemoteController();
        rc.addCommand("2", new AllLightsTurnOffCommand(smartHome));
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
        System.out.println("Демонстрация работы сторонней библиотеки через адаптер");
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(new EventProcessorCCAdapter(new EventProcessorChooser(eventProcessor)));
        sensorEventsManager.start();
        System.out.println("Демонстрация работы пульта");
        rc.onButtonPressed("2", "0");
    }


}
