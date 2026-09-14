package mysmarthome;

public class SmartHomeDemo {
    public static void main(String[] args) {

        //Oppretter en lampe og en termostat
        Lamp lampe = new Lamp("Stue lampe", 20);
        Thermostat termostat = new Thermostat("Stue termostat", 22);

        System.out.println("Status lampe: ");
        lampe.displayStatus();
        termostat.displayStatus();

        // Slår de på
        lampe.turnOn();
        termostat.turnOn();

        // Endre spesifikkke verdier
        lampe.setBrightness(69);
        termostat.setTemperature(19);

        System.out.println("Status etter endring: ");
        lampe.displayStatus();
        termostat.displayStatus();

        System.out.println("Bruk gjennom felles type (SmartDevice): ");
        SmartDevice[] devices = {lampe, termostat};
        
        for (SmartDevice device : devices) {
            device.displayStatus();
        }

    }
}
