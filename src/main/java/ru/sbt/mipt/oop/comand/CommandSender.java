package ru.sbt.mipt.oop.comand;

/**
 * Класс отвечает за отправку команд. Получает на вход команду и отправляет ее.
 */
public class CommandSender {
    SensorCommand command;
    public CommandSender(SensorCommand command) {
        this.command = command;
    }
    public void sendCommand() {
        System.out.println("Pretent we're sending command " + command);
    }
}
