package ru.sbt.mipt.oop.event;

/**
 * Класс для создания рандомного события
 */
public class RandomEventGenerator {
    /**
     * Возвращает новое событие с вероятностью 95, с вероятностью 5 возвращает пустое событие
     * @return SensorEvent
     */
    public static SensorEvent getNextSensorEvent() {
        if (Math.random() < 0.05) return null;
        String code;
        SensorEventType sensorEventType = SensorEventType.values()[(int) (6 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        if (Math.random() < 0.5) {
            code = "0000";
        } else {
            code = "1111";
        }
        return new SensorEvent(sensorEventType, objectId, code);
    }
}
