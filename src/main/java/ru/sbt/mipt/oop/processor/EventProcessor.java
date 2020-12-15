package ru.sbt.mipt.oop.processor;

import ru.sbt.mipt.oop.event.SensorEvent;

/**
 * Интерфейс обработки событий
 */
public interface EventProcessor {
    public void handleEvent(SensorEvent event);
}
