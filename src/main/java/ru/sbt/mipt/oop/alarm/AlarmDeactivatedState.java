package ru.sbt.mipt.oop.alarm;

public class AlarmDeactivatedState implements AlarmState{
     private Alarm alarm;
     public AlarmDeactivatedState(Alarm alarm) {
         this.alarm = alarm;
     }
    @Override
    public void activate(String code) {
         alarm.setCode(code);
         alarm.changeState(new AlarmActivatedState(alarm));
    }

    @Override
    public void deactivate(String code) {

    }

    @Override
    public void activateAlert() {
        alarm.changeState(new AlarmAlertState(alarm));
    }

    public String toString() {
         return "Alarm state changed to deactivated";
    }
}
