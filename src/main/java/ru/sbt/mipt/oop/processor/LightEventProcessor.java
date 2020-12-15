package ru.sbt.mipt.oop.processor;

import ru.sbt.mipt.oop.action.*;
import ru.sbt.mipt.oop.home.SmartHome;
import ru.sbt.mipt.oop.event.SensorEvent;

import static ru.sbt.mipt.oop.event.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.event.SensorEventType.LIGHT_ON;

/**
 * Класс для обработки событий, связанных со светом
 */
public class LightEventProcessor implements EventProcessor {
    private SmartHome smartHome;

    public LightEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    /**
     * Принимает событие, проверяет подходит ли оно для обработки и обрабатывает
     * @param event
     */
    public void handleEvent(SensorEvent event) {
        if (event.getType() == LIGHT_ON) {
            Action action = new LightOnAction(event);
            smartHome.execute(action);
        }
        if (event.getType() == LIGHT_OFF) {
            Action action = new LightOffAction(event);
            smartHome.execute(action);
        }
    }
}
