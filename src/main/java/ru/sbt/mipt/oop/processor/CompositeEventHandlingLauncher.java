package ru.sbt.mipt.oop.processor;


import ru.sbt.mipt.oop.event.SensorEvent;

import java.util.ArrayList;
import java.util.Collection;


/**
 * Класс обеспечивает цикл обработки событий
 */
public class CompositeEventHandlingLauncher implements EventProcessor {
    private Collection<EventProcessor> eventProcessor;

    public CompositeEventHandlingLauncher(Collection<EventProcessor> eventProcessor) {
        this.eventProcessor = eventProcessor;
    }
    /**
     *
     * @param event
     * принимает событие и дом, в котором работает, создает коллекцию обработчиков и прокидывает через нее событие
     */
    @Override
    public void handleEvent(SensorEvent event) {
        for (EventProcessor processor: eventProcessor) {
            processor.handleEvent(event);
        }
    }
}
