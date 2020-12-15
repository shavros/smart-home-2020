package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
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
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        SensorEventsManager sensorEventsManager = context.getBean(SensorEventsManager.class);
        sensorEventsManager.start();
    }


}
