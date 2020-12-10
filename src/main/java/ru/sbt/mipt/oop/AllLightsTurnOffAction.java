package ru.sbt.mipt.oop;

public class AllLightsTurnOffAction implements Action{
    @Override
    public void aply(Object object) {
        if (object instanceof Light) {
            ((Light) object).setOn(false);
        }
    }
}
