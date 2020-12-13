package ru.sbt.mipt.oop.processor;

import ru.sbt.mipt.oop.home.SmartHome;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.event.SensorEventType;

public class AlarmActivateEventProcessor implements EventProcessor {
    private SmartHome smartHome;

    public AlarmActivateEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        if (event.getType() == SensorEventType.ALARM_ACTIVATE) {
            smartHome.getAlarm().activate(event.getCode());
        }
    }
}
