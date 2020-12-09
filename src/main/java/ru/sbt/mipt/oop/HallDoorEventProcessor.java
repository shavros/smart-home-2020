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
            for (Room room : smartHome.getRooms()) {
                if (room.getName().equals("hall")) {
                    for (Door door : room.getDoors()) {
                        if (door.getId().equals(event.getObjectId())) {
                            for (Room homeRoom : smartHome.getRooms()) {
                                for (Light light : homeRoom.getLights()) {
                                    light.setOn(false);
                                    SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                                    CommandSender.sendCommand(command);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
