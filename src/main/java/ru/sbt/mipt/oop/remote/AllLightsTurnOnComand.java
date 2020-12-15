package ru.sbt.mipt.oop.remote;

import ru.sbt.mipt.oop.home.Light;
import ru.sbt.mipt.oop.home.Room;
import ru.sbt.mipt.oop.home.SmartHome;

public class AllLightsTurnOnComand implements Comand{
    private SmartHome smartHome;

    public AllLightsTurnOnComand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        for (Room room: smartHome.getRooms()) {
            for (Light light: room.getLights()) {
                light.setOn(true);
            }
        }
    }
}
