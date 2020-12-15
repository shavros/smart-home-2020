package ru.sbt.mipt.oop.remote;

import ru.sbt.mipt.oop.alarm.AlarmAlertState;
import ru.sbt.mipt.oop.home.SmartHome;

public class AlertActivateComand implements Comand{
    SmartHome smartHome;
    public AlertActivateComand (SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.getAlarm().changeState(new AlarmAlertState(smartHome.getAlarm()));
    }
}
