package ru.sbt.mipt.oop;


import java.util.ArrayList;
import java.util.Collection;


/**
 * Класс обеспечивает цикл обработки событий
 */
public class EventProcessorChooser{
    /**
     *
     * @param event
     * @param smartHome
     * принимает событие и дом, в котором работает, создает коллекцию обработчиков и прокидывает через нее событие
     */
    public static void chooseEventProcessor(SensorEvent event, SmartHome smartHome) {
        Collection<EventProcessor> eventProcessor = new ArrayList<EventProcessor>();
        eventProcessor.add(new DoorEventProcessor(smartHome));
        eventProcessor.add(new HallDoorEventProcessor(smartHome));
        eventProcessor.add(new LightEventProcessor(smartHome));
        while (event != null) {
            for (EventProcessor processor: eventProcessor) {
                processor.handleEvent(event);
            }
            event = RandomEventGenerator.getNextSensorEvent();
            }
        }
    }
