package ru.sbt.mipt.oop.remote;

import ru.sbt.mipt.oop.action.Actionable;
import ru.sbt.mipt.oop.action.AllLightsTurnOffAction;
import ru.sbt.mipt.oop.home.Light;
import ru.sbt.mipt.oop.home.Room;
import ru.sbt.mipt.oop.home.SmartHome;

public class AllLightsTurnOffCommand implements Comand{
    private SmartHome smartHome;
    public AllLightsTurnOffCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        for (Room room: smartHome.getRooms()) {
            for (Light light: room.getLights()) {
                light.setOn(false);
            }
        }
        System.out.println("Весь свет выключен по команде с пульта");
    }
}
