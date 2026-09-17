package mysmarthome;
import java.util.ArrayList;

public class SmartHome {
    private ArrayList<String> devices;

    public SmartHome() {
        devices = new ArrayList<>();
    }

    public void addDevice(String device) {
        devices.add(device);
    }

    public ArrayList<String> getDevices() {
        return devices;
    }

    public void addDevices(ArrayList<String> newDevices) {
        devices.addAll(newDevices);
    }



}
