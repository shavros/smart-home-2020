package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.home.Door;
import ru.sbt.mipt.oop.home.Room;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.home.SmartHome;

public class HallDoorCloseAction implements Action {
    private String objectId;
    private SmartHome smartHome;
    private String currentPlace;

    public HallDoorCloseAction(SensorEvent event, SmartHome smartHome) {
        this.objectId = event.getObjectId();
        this.smartHome = smartHome;
    }

    @Override
    public void apply(Object object) {
        if (object instanceof Room && ((Room) object).getName().equals("hall")) {
            for (Door door: ((Room) object).getDoors()) {
                if (door.getId().equals(objectId)) {
                    Action action = new AllLightsTurnOffAction();
                    smartHome.execute(action);
                    System.out.println("All lights were turned off");
                }
            }
        }
    }
}
