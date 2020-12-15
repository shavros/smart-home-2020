package ru.sbt.mipt.oop.home;

import ru.sbt.mipt.oop.action.Action;
import ru.sbt.mipt.oop.action.Actionable;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.home.Room;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {
    Collection<Room> rooms;
    Alarm alarm;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms, Alarm alarm) {
        this.rooms = rooms;
        this.alarm = alarm;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public Alarm getAlarm() {
        return alarm;
    }

    @Override
    public void execute(Action action) {
        for(Room room: rooms) {
            room.execute(action);
        }
    }
}
