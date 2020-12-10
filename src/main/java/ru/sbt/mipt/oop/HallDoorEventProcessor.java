package ru.sbt.mipt.oop;

/**
 * Класс обрабатывает событие закрытия входной двери
 */
public class HallDoorEventProcessor implements EventProcessor{
    private SmartHome smartHome;

    public HallDoorEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    /**
     *
     * @param event
     * Получает на вход событие, проверяет, подходит ли оно ему для обработки и если да, то вызывает отправитель команд
     */
    public void handleEvent(SensorEvent event) {
        if (event.getType() == SensorEventType.DOOR_CLOSED) {
            Action action = new HallDoorCloseAction(event, smartHome);
            smartHome.execute(action);
        }
    }
}
