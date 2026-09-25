package mysmarthome;

public class Lamp extends SmartDevice implements Schedulable {
    private int brightness;
    private String scheduledTime;
    
    public Lamp(String name, int brightness) {
        super(name);
        this.brightness = brightness;
        this.scheduledTime = null;
    }

    // Må ha gyldig verdi for lysstyrke
    public void setBrightness(int brightness) {
    if (brightness < 0 || brightness > 100) {
        throw new IllegalArgumentException("Lysstyrke må være mellom 0 og 100");
        }
    this.brightness = brightness;
    }

    public int getBrightness() {
        return this.brightness;
    }

    @Override
    public void schedule(String time) {
        this.scheduledTime = time;
    }

    @Override
    public String getScheduledTime() {
        return scheduledTime;
    }

    // Viser status for lampen
    @Override 
    public void displayStatus() {
        System.out.println("Lampe: " + getName()
            + ", Status: " + (isOn() ? "på" : "av")
            + ", Lysstyrke: " + brightness
            + ", Planlagt tid: " + (scheduledTime == null ? "ingen" : scheduledTime));


    }
}
