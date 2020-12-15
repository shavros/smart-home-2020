package ru.sbt.mipt.oop.remote;

import ru.sbt.mipt.oop.alarm.AlarmAlertState;
import ru.sbt.mipt.oop.home.SmartHome;

public class AlertActivateCommand implements Command {
    SmartHome smartHome;
    public AlertActivateCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.getAlarm().activateAlert();
    }
}
