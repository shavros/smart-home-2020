package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.home.Light;

public class AllLightsTurnOffAction implements Action {
    @Override
    public void apply(Object object) {
        if (object instanceof Light) {
            ((Light) object).setOn(false);
        }
    }
}
