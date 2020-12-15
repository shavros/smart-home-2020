package ru.sbt.mipt.oop.remote;

import rc.RemoteControl;

import java.util.HashMap;

public class SmartHomeRemoteController implements RemoteControl {
    private HashMap<String, Comand> remoteComands = new HashMap<>();

    /**public SmartHomeRemoteController(HashMap<String, Comand> remoteComands) {
        this.remoteComands = remoteComands;
    }*/

    public void addCommand(String buttonCode, Comand comand) {
        remoteComands.put(buttonCode, comand);
    }

    @Override
    public void onButtonPressed(String buttonCode, String rcId) {
        if (remoteComands.containsKey(buttonCode)) {
            remoteComands.get(buttonCode).execute();
        }
    }
}
