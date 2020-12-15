package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.EventHandler;
import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.action.MessageSender;
import ru.sbt.mipt.oop.action.SMSMessageSender;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.event.SensorEventType;
import ru.sbt.mipt.oop.home.SmartHome;
import ru.sbt.mipt.oop.home.SmartHomeReaderWriter;
import ru.sbt.mipt.oop.home.SmartHomeReaderWriterJson;
import ru.sbt.mipt.oop.processor.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

@Configuration
public class ApplicationConfig {
    @Bean
    SensorEventsManager sensorEventsManager(EventHandler eventHandler) {
        SensorEventsManager ret = new SensorEventsManager();
        ret.registerEventHandler(eventHandler);
        return ret;
    }



    @Bean
    EventHandler EventProcessorCCAdapter(HashMap<String, SensorEventType> eventTypeHashMap, EventProcessor adapted) {
        return new EventProcessorCCAdapter(eventTypeHashMap, adapted);
    }

    @Bean
    HashMap<String, SensorEventType> eventTypeHashMap() {
        HashMap<String, SensorEventType> ret = new HashMap<>();
        ret.put("LightIsOn", SensorEventType.LIGHT_ON);
        ret.put("LightIsOff", SensorEventType.LIGHT_OFF);
        ret.put("DoorIsOpen", SensorEventType.DOOR_OPEN);
        ret.put("DoorIsClosed", SensorEventType.DOOR_CLOSED);
        return ret;
    }

    @Bean
    EventProcessor CompositeEventHandlingLauncher(SmartHome smartHome, Alarm alarm, MessageSender sender) {
        EventProcessor handler = new CompositeEventHandlingLauncher(Arrays.asList(new LightEventProcessor(smartHome),
                new DoorEventProcessor(smartHome),
                new HallDoorEventProcessor(smartHome)));
        // signalization decorator
        handler = new AlarmEventHandlingDecorator(handler, alarm, sender);
        // signalization handlers
        handler = new CompositeEventHandlingLauncher(Arrays.asList(new AlarmActivateEventProcessor(smartHome),
                new AlarmDeactivateEventProcessor(smartHome),
                handler));
        return handler;
    }

    @Bean
    SmartHome smartHome() {
        SmartHomeReaderWriter reader = new SmartHomeReaderWriterJson();
        return reader.readHome("output.js");
    }

    @Bean
    MessageSender messageSender() {
        return new SMSMessageSender();
    }

    @Bean
    Alarm alarm() {
        return new Alarm("0000");
    }
}
