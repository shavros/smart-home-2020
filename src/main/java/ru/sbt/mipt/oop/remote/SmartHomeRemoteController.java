package ru.sbt.mipt.oop.remote;

import rc.RemoteControl;

import java.util.HashMap;
import java.util.Map;

public class SmartHomeRemoteController implements RemoteControl {
    private Map<String, Command> remoteComands;

    /**public SmartHomeRemoteController(HashMap<String, Comand> remoteComands) {
        this.remoteComands = remoteComands;
    }*/

    public SmartHomeRemoteController(HashMap<String, Command> remoteComands) {
        this.remoteComands = remoteComands;
    }

    @Override
    public void onButtonPressed(String buttonCode, String rcId) {
        if (remoteComands.containsKey(buttonCode)) {
            remoteComands.get(buttonCode).execute();
        }
    }
}
