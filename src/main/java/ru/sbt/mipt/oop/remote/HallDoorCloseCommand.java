package ru.sbt.mipt.oop.remote;

import ru.sbt.mipt.oop.home.Door;
import ru.sbt.mipt.oop.home.Room;
import ru.sbt.mipt.oop.home.SmartHome;

public class HallDoorCloseCommand implements Command {
    private SmartHome smartHome;

    public HallDoorCloseCommand(SmartHome smartHome) {
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
