package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.home.Light;
import ru.sbt.mipt.oop.home.Room;
import ru.sbt.mipt.oop.event.SensorEvent;

public class LightOffAction implements Action {
    private String objectId;
    private String currentPlace;

    public LightOffAction(SensorEvent event) {
        this.objectId = event.getObjectId();
    }

    @Override
    public void apply(Object object) {
        if (object instanceof Room) {
            currentPlace = ((Room) object).getName();
        }
        if (object instanceof Light) {
            if (((Light) object).getId().equals(objectId)) {
                ((Light) object).setOn(false);
                System.out.println("Light " + objectId + " in room " + currentPlace + " was turned off.");
            }
        }
    }
}
