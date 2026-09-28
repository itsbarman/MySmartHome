package mysmarthome.myphone;

import mysmarthome.Lamp;
import mysmarthome.SmartHome;
import mysmarthome.Thermostat;

public class MyPhoneDemo {
    public static void main(String[] args) {
        MyPhone phone = new MyPhone("Samsung", "Galaxy S21",
        256, 8);

        SmartHome home = new SmartHome();
        Lamp lamp = new Lamp("Lampe", 40);
        Thermostat thermostat = new Thermostat("Termostat", 19.5);
        home.addDevice(lamp);
        home.addDevice(thermostat);

        SmartHomeApp smartHomeApp = new SmartHomeApp("1.0", home);
        phone.installApp(smartHomeApp);
        phone.startApp("SmartHome");

        smartHomeApp.turnOn(0);
        smartHomeApp.changeBrightness(0, 80);
        smartHomeApp.changeTemperature(1, 21.0);
        smartHomeApp.schedule(0, "07:00");

        System.out.println("Hjemmet etter endringer fra appen:");
        home.displayAllDevices();

        App spotify = new App("Spotify", "1.0");
        App youtube = new App("YouTube", "2.0");

        phone.installApp(spotify);
        phone.installApp(youtube);

        spotify.run();
        youtube.run(true);

        phone.connectHeadset("JBL headset");

        phone.use(25);
        phone.charge(10);
        phone.chargePhone();

        phone.displayInfo();
        phone.listApps();

    }
}