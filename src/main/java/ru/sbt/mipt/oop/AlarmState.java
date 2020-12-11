package ru.sbt.mipt.oop;

public interface AlarmState {
    public abstract void activate(String code);
    public abstract void deactivate(String code);
    public abstract void activateAlert();
}
