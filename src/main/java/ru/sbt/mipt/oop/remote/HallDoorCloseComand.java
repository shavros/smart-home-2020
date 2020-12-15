package ru.sbt.mipt.oop.remote;

import ru.sbt.mipt.oop.action.Actionable;
import ru.sbt.mipt.oop.action.HallDoorCloseAction;
import ru.sbt.mipt.oop.home.Door;
import ru.sbt.mipt.oop.home.Light;
import ru.sbt.mipt.oop.home.Room;
import ru.sbt.mipt.oop.home.SmartHome;

public class HallDoorCloseComand implements Comand{
    private SmartHome smartHome;

    public HallDoorCloseComand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        for (Room room: smartHome.getRooms()){
            if (room.getName().equals("hall")){
                for(Door door: room.getDoors()) {
                    door.setOpen(false);
                }
            }
        }
    }
}
