package ru.sbt.mipt.oop.alarm;

public class AlarmActivatedState implements AlarmState{
    private Alarm alarm;

    public AlarmActivatedState(Alarm alarm) {
        this.alarm = alarm;
    }
    @Override
    public void activate(String code) {

    }

    @Override
    public void deactivate(String code) {
        if (alarm.getCode().equals(code)) {
            alarm.changeState(new AlarmDeactivatedState(alarm));
        } else {
            alarm.activateAlert();
        }
    }

    @Override
    public void activateAlert() {
        alarm.changeState(new AlarmAlertState(alarm));
    }

    public String toString() {
        return "Alarm state changed to activated";
    }
}
