package ru.sbt.mipt.oop;

public class Alarm {
    private AlarmState state;
    private String code;

    protected String getCode() {
        return this.code;
    }

    public Alarm(String code) {
        this.code = code;
        //this.state = new AlarmActivatedState(this);
    }

    public void activate(String code) {
        this.state.activate(code);
    }

    public void deactivate(String code) {
        this.state.deactivate(code);
    }

    public void activateAlert() {this.state.activateAlert();}

    protected void changeState(AlarmState state) {
        this.state = state;
        System.out.println(state.toString());
    }

    protected void setCode(String code) {
        this.code = code;
    }
}
