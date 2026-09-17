package mysmarthome;
import java.util.ArrayList;
import java.util.List;

public class SmartHome {
    private List<SmartDevice> devices;

    public SmartHome() {
        devices = new ArrayList<>();
    }

    public void addDevice(SmartDevice device) {
        devices.add(device);
    }
    
    public void displayAllDevices() {
        for (int i = 0; i < devices.size(); i++) {
            SmartDevice device = devices.get(i);
            System.out.print((i + 1) + ". ");
            device.displayStatus();
        }
    }

    public void turnOnDevice(SmartDevice device) {
        device.turnOn();
    }

    public void turnOnAllDevices() {
        for (SmartDevice device : devices) {
            device.turnOn();
        }
    }

    public void turnOffDevice(SmartDevice device) {
        device.turnOff();
    }

    public void turnOffAllDevices() {
        for (SmartDevice device : devices) {
            device.turnOff();
        }
    }

    public int getDeviceCount() {
        return devices.size();
    }

    public SmartDevice getDevice(int index) {
        return devices.get(index);
    }

}
