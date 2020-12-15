package ru.sbt.mipt.oop.remote;

import ru.sbt.mipt.oop.alarm.AlarmActivatedState;
import ru.sbt.mipt.oop.home.SmartHome;

public class AlarmActivateCommand implements Command {
    private SmartHome smartHome;

    public AlarmActivateCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.getAlarm().activate("0000");
    }
}
