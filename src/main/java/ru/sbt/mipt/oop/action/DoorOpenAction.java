package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.home.Door;
import ru.sbt.mipt.oop.home.Room;
import ru.sbt.mipt.oop.event.SensorEvent;

public class DoorOpenAction implements Action {
    private String objectId;
    private String currentPlace;

    public DoorOpenAction(SensorEvent event) {
        this.objectId = event.getObjectId();
    }

    @Override
    public void apply(Object object) {
        if (object instanceof Room) {
            currentPlace = ((Room) object).getName();
        }
        if (object instanceof Door) {
            if (((Door) object).getId().equals(objectId)) {
                ((Door) object).setOpen(true);
                System.out.println("Door " + objectId + " in room " + currentPlace + " was opened.");
            }
        }
    }
}
