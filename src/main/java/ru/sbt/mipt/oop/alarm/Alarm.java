package ru.sbt.mipt.oop.alarm;

public class Alarm {
    private AlarmState state;
    private String code;

    protected String getCode() {
        return this.code;
    }

    public Alarm(String code) {
        this.code = code;
    }

    public void activate(String code) {
        this.state.activate(code);
    }

    public void deactivate(String code) {
        this.state.deactivate(code);
    }

    public void activateAlert() {this.state.activateAlert();}

    public boolean isActivated() {
        return state instanceof AlarmActivatedState;
    }

    public boolean isDeactivated() {
        return state instanceof AlarmDeactivatedState;
    }

    public boolean isAlert() {
        return state instanceof AlarmAlertState;
    }

    void changeState(AlarmState state) {
        this.state = state;
        System.out.println(state.toString());
    }

    protected void setCode(String code) {
        this.code = code;
    }
}
