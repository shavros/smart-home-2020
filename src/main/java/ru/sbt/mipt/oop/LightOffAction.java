package ru.sbt.mipt.oop;

public class LightOffAction implements Action{
    private String objectId;
    private String currentPlace;

    public LightOffAction(SensorEvent event) {
        this.objectId = event.getObjectId();
    }

    @Override
    public void aply(Object object) {
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
