package ru.sbt.mipt.oop;

public class LightOnAction implements Action{
    private String objectId;
    private String currentPlace;

    public LightOnAction(SensorEvent event) {
        this.objectId = event.getObjectId();
    }

    @Override
    public void aply(Object object) {
        if (object instanceof Room) {
            currentPlace = ((Room) object).getName();
        }
        if (object instanceof Light) {
            if (((Light) object).getId().equals(objectId)) {
                ((Light) object).setOn(true);
                System.out.println("Light " + objectId + " in room " + currentPlace + " was turned on.");
            }
        }
    }
}
