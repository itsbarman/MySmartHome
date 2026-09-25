package mysmarthome.myphone;

import mysmarthome.Lamp;
import mysmarthome.Schedulable;
import mysmarthome.SmartDevice;
import mysmarthome.SmartHome;
import mysmarthome.Thermostat;

public class SmartHomeApp extends App {
    private SmartHome home;

    public SmartHomeApp(String version, SmartHome home) {
        super("SmartHome", version);
        this.home = home;
    }

    @Override
    public void run() {
        System.out.println("Starter SmartHome-appen");
        home.displayAllDevices();
    }

    public void turnOn(int deviceNumber) {
        SmartDevice device = home.getDevice(deviceNumber);
        home.turnOnDevice(device);
    }

    public void turnOff(int deviceNumber) {
        SmartDevice device = home.getDevice(deviceNumber);
        home.turnOffDevice(device);
    }

    public void changeBrightness(int deviceNumber, int brightness) {
        SmartDevice device = home.getDevice(deviceNumber);
        if (device instanceof Lamp) {
            ((Lamp) device).setBrightness(brightness);
        }
    }

    public void changeTemperature(int deviceNumber, double temperature) {
        SmartDevice device = home.getDevice(deviceNumber);
        if (device instanceof Thermostat) {
            ((Thermostat) device).setTemperature(temperature);
        }
    }

    public void schedule(int deviceNumber, String time) {
        SmartDevice device = home.getDevice(deviceNumber);
        if (device instanceof Schedulable) {
            home.scheduleDevice((Schedulable) device, time);
        }
    }
}