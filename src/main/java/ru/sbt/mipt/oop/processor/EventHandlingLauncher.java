package ru.sbt.mipt.oop.processor;

import ru.sbt.mipt.oop.event.SensorEvent;

public interface EventHandlingLauncher {
    public void chooseEventProcessor(SensorEvent event);
}
