package ru.sbt.mipt.oop.processor;

import ru.sbt.mipt.oop.action.MessageSender;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.alarm.AlarmAlertState;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.event.SensorEventType;

public class AlarmEventHandlingDecorator implements EventProcessor {
    private EventProcessor basicChooser;
    private Alarm alarm;
    private MessageSender sender;

    public AlarmEventHandlingDecorator(EventProcessor basicChooser, Alarm alarm, MessageSender sender) {
        this.basicChooser = basicChooser;
        this.alarm = alarm;
        this.sender = sender;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        System.out.println(event.toString()+"requested");
        if (alarm.isDeactivated()) {
            basicChooser.handleEvent(event);
            return;
        }
        if (alarm.isActivated()) {
            alarm.activateAlert();
            sender.send("Отправляю SMS хозяину дома, что-то произошло");
            return;
        }
        if (alarm.isAlert()) {
            if (event.getType() == SensorEventType.ALARM_DEACTIVATE) {
                basicChooser.handleEvent(event);
            }
            if (alarm.isAlert()) {
                sender.send("Отправляю смс хозяину дома, дом заблокирован");
            }
            return;
        }

    }
}
