package mysmarthome;
import java.util.ArrayList;
import java.util.List;

public class SmartHome {
    private List<String> devices;

    public SmartHome() {
        // Opprett samlingen
        devices = new ArrayList<>();
    }

    public void addDevice(SmartDevice device) {
        // Legg til en enhet
        devices.add(device.getName());
    }
    
    public void displayAllDevices() {
        // gå gjennom alle enhetene, kall displayStatus() på hver enhet
        for (String deviceName : devices) {
            System.out.println("Device: " + deviceName);
        }
    }

    public void turnOnDevice(SmartDevice device) {
        // Slå på vsalgt enhet
        device.turnOn();
    }

    public void turnOffDevice(SmartDevice device) {
        // Slå av valgt enhet
        device.turnOff();
    }

    public void turnOffAllDevices() {
        // Slå av alle enheter
        for (String deviceName : devices) {
            System.out.println("Turning off device: " + deviceName);
        }
    }

}
