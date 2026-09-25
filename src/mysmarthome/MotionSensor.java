package mysmarthome;

public class MotionSensor extends SmartDevice {
    private boolean motionDetected;

    public MotionSensor(String name) {
        super(name);
        this.motionDetected = false;
    }

    public void detectMotion() {
        motionDetected = true;
    }

    public void clearMotion() {
        motionDetected = false;
    }

    public boolean isMotionDetected() {
        return motionDetected;
    }

    @Override
    public void displayStatus() {
        System.out.println("Bevegelsessensor: " + getName()
            + ", Status: " + (isOn() ? "på" : "av")
            + ", Bevegelse: " + (motionDetected ? "oppdaget" : "ikke oppdaget"));
    }
}