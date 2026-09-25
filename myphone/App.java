package myphone;
public class App {
    private String appName;
    private String version;

    public App(String appName, String version) {
        this.appName = appName;
        this.version = version;
    }

    public String getAppName() {
        return appName;
    }

    public String getVersion() {
        return version;
    }

    public void run() {
        System.out.println("Running " + appName + " version " + version);
    }

    public void run(boolean debugMode) {
        if (debugMode) {
            System.out.println("Running " + appName + " version " 
            + version + " in debug mode");
        } else {
            run();
        }
    }


}











