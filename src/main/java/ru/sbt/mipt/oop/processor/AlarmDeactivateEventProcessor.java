package ru.sbt.mipt.oop.processor;

import ru.sbt.mipt.oop.home.SmartHome;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.event.SensorEventType;

public class AlarmDeactivateEventProcessor implements EventProcessor {
    private SmartHome smartHome;

    public AlarmDeactivateEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        if (event.getType() == SensorEventType.ALARM_DEACTIVATE) {
            smartHome.getAlarm().deactivate(event.getCode());
        }
    }
}
