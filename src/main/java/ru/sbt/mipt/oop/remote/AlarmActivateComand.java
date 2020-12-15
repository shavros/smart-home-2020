package ru.sbt.mipt.oop.remote;

import ru.sbt.mipt.oop.alarm.AlarmActivatedState;
import ru.sbt.mipt.oop.home.SmartHome;

public class AlarmActivateComand implements Comand{
    private SmartHome smartHome;

    public AlarmActivateComand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.getAlarm().changeState(new AlarmActivatedState(smartHome.getAlarm()));
    }
}
