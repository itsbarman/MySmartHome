package mysmarthome;

public class SmartDevice {
    private String name;
    private boolean isOn;
    

    public SmartDevice(String name) {
        this.name = name;
        this.isOn = false;
    }

    public boolean isOn() {
        return this.isOn;
    }

    public void turnOn() {
        this.isOn = true;
    }

    public void turnOff() {
        this.isOn = false;
    }

    public String getName() {
        return this.name;
    }

    public void displayStatus() {
        System.out.println("Enhet " + name + " er " + (isOn ? "på" : "av"));
    }
}