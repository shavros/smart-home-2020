package ru.sbt.mipt.oop;

/**
 * Класс отвечает за отправку команд. Получает на вход команду и отправляет ее.
 * @param команда, которую необходим отправить
 */
public class CommandSender {
    public static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
}
