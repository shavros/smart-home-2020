package ru.sbt.mipt.oop;

public class AlarmActivateEventProcessor implements EventProcessor{
    private SmartHome smartHome;

    public AlarmActivateEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        if (event.getType() == SensorEventType.ALARM_ACTIVATE) {
            smartHome.alarm.activate(event.getCode());
        }
    }
}
