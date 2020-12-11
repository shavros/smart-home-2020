package ru.sbt.mipt.oop;

public class AlarmAlertState implements AlarmState{
    private Alarm alarm;
    public AlarmAlertState(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void activate(String code) {

    }

    @Override
    public void deactivate(String code) {
        if (code == alarm.getCode()) {
            alarm.changeState(new AlarmDeactivatedState(alarm));
        }
    }

    @Override
    public void activateAlert() {
    }

    public String toString() {
        return "Alarm state changed to ALERT!";
    }
}
