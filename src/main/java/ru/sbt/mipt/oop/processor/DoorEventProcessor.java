package ru.sbt.mipt.oop.processor;

import ru.sbt.mipt.oop.action.*;
import ru.sbt.mipt.oop.home.SmartHome;
import ru.sbt.mipt.oop.event.SensorEvent;

import static ru.sbt.mipt.oop.event.SensorEventType.*;

/**
 * Класс имплементит интерфейс обработки событий и применяет его для событий, связанных со светом.
 */
public class DoorEventProcessor implements EventProcessor {
    private SmartHome smartHome;

    public DoorEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    /**
     *
     * @param event
     * Принимает на вход событие. Проверяет, подходит ли оно ему для обработки
     * и обрабатывает.
     */

    @Override
    public void handleEvent(SensorEvent event) {
        if (event.getType() == DOOR_OPEN) {
            Action action = new DoorOpenAction(event);
            smartHome.execute(action);
        }
        if (event.getType() == DOOR_CLOSED) {
            Action action = new DoorCloseAction(event);
            smartHome.execute(action);
        }
    }
}
