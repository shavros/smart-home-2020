package ru.sbt.mipt.oop.processor;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.event.SensorEventType;

import java.util.HashMap;
import java.util.Map;

public class EventProcessorCCAdapter implements EventHandler {
    private EventProcessor adaptedEventHandlingLauncher;
    private Map<String, SensorEventType> eventTypeMap = new HashMap<>();

    public EventProcessorCCAdapter(HashMap<String, SensorEventType> eventTypeMap, EventProcessor adaptedEventHandlingLauncher) {
        this.eventTypeMap = eventTypeMap;
        this.adaptedEventHandlingLauncher = adaptedEventHandlingLauncher;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        if (!eventTypeMap.containsKey(event.getEventType())) {
            System.out.println("Адаптер не поддерживает данный вид событий");
        } else {
            SensorEvent sensorEvent = new SensorEvent(eventTypeMap.get(event.getEventType()), event.getObjectId(), "0");
            adaptedEventHandlingLauncher.handleEvent(sensorEvent);
        }
    }
}
