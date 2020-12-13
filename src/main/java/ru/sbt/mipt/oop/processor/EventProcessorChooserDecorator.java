package ru.sbt.mipt.oop.processor;

import ru.sbt.mipt.oop.action.MessageSender;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.alarm.AlarmAlertState;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.event.SensorEventType;

public class EventProcessorChooserDecorator implements Chooser{
    private EventProcessorChooser basicChooser;
    private Alarm alarm;
    private MessageSender sender;

    public EventProcessorChooserDecorator(EventProcessorChooser basicChooser, Alarm alarm, MessageSender sender) {
        this.basicChooser = basicChooser;
        this.alarm = alarm;
        this.sender = sender;
    }

    @Override
    public void chooseEventProcessor(SensorEvent event) {
        System.out.println(event.toString()+"requested");
        if (alarm.isDeactivated()) {
            basicChooser.chooseEventProcessor(event);
            return;
        }
        if (alarm.isActivated()) {
            basicChooser.chooseEventProcessor(event);
            alarm.changeState(new AlarmAlertState(alarm));
            sender.send("Отправляю SMS хозяину дома, что-то произошло");
            return;
        }
        if (alarm.isAlert()) {
            if (event.getType() == SensorEventType.ALARM_DEACTIVATE) {
                basicChooser.chooseEventProcessor(event);
            }
            if (alarm.isAlert()) {
                sender.send("Отправляю смс хозяину дома, дом заблокирован");
            }
            return;
        }

    }
}
