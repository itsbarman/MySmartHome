package mysmarthome;

public class Lamp extends SmartDevice {
    private int brightness;
    
    public Lamp(String name, int brightness) {
        super(name);
        this.brightness = brightness;
    }


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
    public void displayStatus() {
        System.out.println("Lampe: " + getName()
            + ", Status: " + (isOn() ? "på" : "av")
            + ", Lysstyrke: " + brightness);


    }
}
