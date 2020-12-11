package ru.sbt.mipt.oop;

public class SensorEvent {
    private final SensorEventType type;
    private final String objectId;
    private String code;

    public SensorEvent(SensorEventType type, String objectId, String code) {
        this.type = type;
        this.objectId = objectId;
        this.code = code;
    }


    public SensorEventType getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public String getObjectId() {
        return objectId;
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}
