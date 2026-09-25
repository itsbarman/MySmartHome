package mysmarthome;

public interface Schedulable {
    void schedule(String time);

    String getScheduledTime();
}