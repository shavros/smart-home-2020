package ru.sbt.mipt.oop.alarm;

public class Alarm {
    private AlarmState state;
    private String code;

    protected String getCode() {
        return this.code;
    }

    public Alarm(String code) {
        this.code = code;
        //this.state = new AlarmDeactivatedState(this);
    }

    public void activate(String code) {
        this.state.activate(code);
    }

    public void deactivate(String code) {
        this.state.deactivate(code);
    }

    public void activateAlert() {this.state.activateAlert();}

    public boolean isActivated() {
        if (state instanceof AlarmActivatedState) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isDeactivated() {
        if (state instanceof AlarmDeactivatedState) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAlert() {
        if (state instanceof AlarmAlertState) {
            return true;
        } else {
            return false;
        }
    }

    public void changeState(AlarmState state) {
        this.state = state;
        System.out.println(state.toString());
    }

    protected void setCode(String code) {
        this.code = code;
    }
}
