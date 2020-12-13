package ru.sbt.mipt.oop.processor;

import ru.sbt.mipt.oop.event.SensorEvent;

public interface Chooser {
    public void chooseEventProcessor(SensorEvent event);
}
