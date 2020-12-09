package ru.sbt.mipt.oop;

/**
 * Интерфейс обработки событий
 */
public interface EventProcessor {
    public void handleEvent(SensorEvent event);
}
