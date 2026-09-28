package mysmarthome.myphone;

import mysmarthome.Lamp;
import mysmarthome.MotionSensor;
import mysmarthome.SmartHome;
import mysmarthome.Thermostat;

public class MorningDemo {
    public static void main(String[] args) {
        SmartHome home = new SmartHome();
        Lamp entryLight = new Lamp("Inngangslys", 30);
        Lamp kitchenLight = new Lamp("Kjøkkenlys", 50);
        Thermostat heating = new Thermostat("Stuevarme", 19.5);
        MotionSensor hallSensor = new MotionSensor("Gangsensor");

        home.addDevice(entryLight);   // 0
        home.addDevice(kitchenLight); // 1
        home.addDevice(heating);      // 2
        home.addDevice(hallSensor);   // 3

        MyPhone phone = new MyPhone("Samsung", "Galaxy S21", 256, 80);
        SmartHomeApp app = new SmartHomeApp("1.0", home);

        System.out.println("Tidlig morgen: startstatus");
        phone.installApp(app);
        phone.startApp("SmartHome");

        app.schedule(2, "06:30");
        app.schedule(0, "07:00");
        System.out.println("\nPlanlagte tider:");
        System.out.println(heating.getName() + ": " + heating.getScheduledTime());
        System.out.println(entryLight.getName() + ": " + entryLight.getScheduledTime());

        System.out.println("Brukeren våkner");
        app.turnOn(2);
        app.changeTemperature(2, 21.0);
        app.turnOn(0);
        app.changeBrightness(0, 80);
        app.turnOn(1);
        app.turnOn(3);
        hallSensor.detectMotion();
        System.out.println("Bevegelse i gangen:");
        hallSensor.displayStatus();
        System.out.println("Hjemmet mens brukeren er hjemme:");
        home.displayAllDevices();

        System.out.println("Brukeren går ut døren");
        hallSensor.clearMotion();
        System.out.println("Brukeren velger 'Slå av alle' i SmartHome-appen.");
        app.turnOffAll();
        System.out.println("Sluttstatus etter avreise:");
        home.displayAllDevices();
    }
}