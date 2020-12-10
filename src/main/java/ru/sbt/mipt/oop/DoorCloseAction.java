package ru.sbt.mipt.oop;

public class DoorCloseAction implements Action{
    private String objectId;
    private String currentPlace;

    public DoorCloseAction(SensorEvent event) {
        this.objectId = event.getObjectId();
    }

    @Override
    public void aply(Object object) {
        if (object instanceof Room) {
            currentPlace = ((Room) object).getName();
        }
        if (object instanceof Door) {
            if (((Door) object).getId().equals(objectId)) {
                ((Door) object).setOpen(false);
                System.out.println("Door " + objectId + " in room " + currentPlace + " was closed.");
            }
        }
    }
}
