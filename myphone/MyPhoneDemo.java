package mysmarthome.myphone;
public class MyPhoneDemo {
    public static void main(String[] args) {
        MyPhone phone = new MyPhone("Samsung", "Galaxy S21",
        256, 8);

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
