package ru.sbt.mipt.oop.processor;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.event.SensorEventType;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EventProcessorCCAdapter implements EventHandler {
    private Chooser adaptedChooser;
    private Map<String, SensorEventType> eventTypeMap = new HashMap<>();

    public EventProcessorCCAdapter(Chooser chooser) {
        this.adaptedChooser = chooser;
        eventTypeMap.put("LightIsOn", SensorEventType.LIGHT_ON);
        eventTypeMap.put("LightIsOf", SensorEventType.LIGHT_OFF);
        eventTypeMap.put("DoorIsOpen", SensorEventType.DOOR_OPEN);
        eventTypeMap.put("DoorIsClosed", SensorEventType.DOOR_CLOSED);
        //eventTypeMap.put("DoorIsLocked", );
        //eventTypeMap.put("DoorIsUnlocked", );
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        SensorEvent sensorEvent = new SensorEvent(eventTypeMap.get(event.getEventType()), event.getObjectId(), "0");
        adaptedChooser.chooseEventProcessor(sensorEvent);
    }
}
