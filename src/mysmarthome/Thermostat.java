package mysmarthome;

public class Thermostat extends SmartDevice implements Schedulable {
    private double temperature;
    private String scheduledTime;

    public Thermostat(String name, double temperature) {
        super(name);
        this.temperature = temperature;
        this.scheduledTime = null;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public void schedule(String time) {
        this.scheduledTime = time;
    }

    @Override
    public String getScheduledTime() {
        return scheduledTime;
    }

    @Override
    public void displayStatus() {
        System.out.println("Termostat: " + getName()
            + ", Status: " + (isOn() ? "på" : "av")
            + ", Temperatur: " + temperature
            + ", Planlagt tid: " + (scheduledTime == null ? "ingen" : scheduledTime));
        
    }
}
