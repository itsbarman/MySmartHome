package mysmarthome.myphone;
import java.util.ArrayList;

import mysmarthome.myphone.App;

public class MyPhone {
    private static final int DEFAULT_CHARGE = 20;  
    // Attributes
    private String brand;
    private String model;
    private int storageCapacity;
    private int batteryLevel;
    private String headset;
    private String appName;
    private ArrayList<String> app;
    private ArrayList<String> headsets;

    // Constructor
    public MyPhone(String brand, String model, int storageCapacity, int batteryLevel) {
        this.brand = brand;
        this.model = model;
        this.storageCapacity = storageCapacity;
        setBatteryLevel(batteryLevel);
        this.app = new ArrayList<>();
        this.headsets = new ArrayList<>();
    }

    
    public void charge(int amount) {
    setBatteryLevel(batteryLevel + amount);
    }


    
    public void use(int amount) {
    setBatteryLevel(batteryLevel - amount);
    }

    // Method to display phone information
    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Storage Capacity: " + storageCapacity + "GB");
        System.out.println("Battery Level: " + batteryLevel + "%");
    }

    // Method to charge the phone with a default amount
    public void chargePhone() {
        charge(DEFAULT_CHARGE);
        System.out.println("Charging phone... Battery level: "
        + batteryLevel + "%");

    }

    // Getters
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    // Setter for batteryLevel with validation
    public void setBatteryLevel(int batterylevel) {
        if (batterylevel < 0) {
            this.batteryLevel = 0;
        } else if (batterylevel > 100) {
            this.batteryLevel = 100;
        } else {
            this.batteryLevel = batterylevel;
        }
    }



public void addApps(ArrayList<String> apps) {
    for (String app : apps) {
        System.out.println("Installing app: " + app);
        this.app.add(app);
    }
}

 public void installApp(App app) {
     System.out.println("Installing app: " + app.getAppName());
     this.app.add(app.getAppName());
     System.out.println("App installed: " + app.getAppName());
 }

 public void listApps() {
    System.out.println("Installed apps:");
    for (String app : this.app) {
        System.out.println("App: " + app);
    }
}

public void connectHeadset(String headset) {
    System.out.println("Connecting headset: " + headset);
    this.headsets.add(headset);
    System.out.println("Headset connected: " + headset);
    }

}

