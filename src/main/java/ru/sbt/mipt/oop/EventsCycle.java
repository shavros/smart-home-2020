package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.action.MessageSender;
import ru.sbt.mipt.oop.event.RandomEventGenerator;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.home.SmartHome;
import ru.sbt.mipt.oop.processor.EventHandlingLauncher;
import ru.sbt.mipt.oop.processor.EventProcessor;
import ru.sbt.mipt.oop.processor.CompositeEventHandlingLauncher;
import ru.sbt.mipt.oop.processor.AlarmEventHandlingDecorator;

import java.util.Collection;

public class EventsCycle {
    SensorEvent event;
    Collection<EventProcessor> eventProcessors;
    SmartHome smartHome;
    MessageSender sender;

    public EventsCycle(SensorEvent event, Collection<EventProcessor> eventProcessor, SmartHome smartHome, MessageSender sender) {
        this.event = event;
        this.eventProcessors = eventProcessor;
        this.smartHome = smartHome;
        this.sender = sender;
    }

    public void start() {
        while (event != null) {
            EventHandlingLauncher eventHandlingLauncher =
                    new AlarmEventHandlingDecorator(new CompositeEventHandlingLauncher(eventProcessors), smartHome.getAlarm(), sender);
            eventHandlingLauncher.chooseEventProcessor(event);
            event = RandomEventGenerator.getNextSensorEvent();
        }
    }
}
