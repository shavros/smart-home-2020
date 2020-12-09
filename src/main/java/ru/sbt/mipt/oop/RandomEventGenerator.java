package ru.sbt.mipt.oop;

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
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}
