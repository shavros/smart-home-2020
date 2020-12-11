package ru.sbt.mipt.oop;

public class AlarmDeactivateEventProcessor implements EventProcessor{
    private SmartHome smartHome;

    public AlarmDeactivateEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        if (event.getType() == SensorEventType.ALARM_DEACTIVATE) {
            smartHome.alarm.deactivate(event.getCode());
        }
    }
}
