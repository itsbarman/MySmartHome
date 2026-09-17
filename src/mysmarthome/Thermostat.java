package mysmarthome;

public class Thermostat extends SmartDevice {
    private double temperature;

    public Thermostat(String name, double temperature) {
        super(name);
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public void displayStatus() {
        System.out.println("Termostat: " + getName()
            + ", Status: " + (isOn() ? "på" : "av")
            + ", Temperatur: " + temperature);
        
    }
}
