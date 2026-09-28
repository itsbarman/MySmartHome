# Endelig designoversikt

```mermaid
classDiagram
    SmartDevice <|-- Lamp
    SmartDevice <|-- Thermostat
    SmartDevice <|-- MotionSensor
    Schedulable <|.. Lamp
    Schedulable <|.. Thermostat
    SmartHome o-- "0..*" SmartDevice : lagrer
    App <|-- SmartHomeApp
    MyPhone o-- "0..*" App : installerte apper
    SmartHomeApp --> SmartHome : bruker
    MorningDemo ..> SmartHome : oppretter
    MorningDemo ..> MyPhone : oppretter
    MorningDemo ..> SmartHomeApp : demonstrerer

    class SmartDevice {
        -String name
        -boolean isOn
        +turnOn()
        +turnOff()
        +displayStatus()
    }
    class Schedulable {
        <<interface>>
        +schedule(String time)
        +getScheduledTime() String
    }
    class Lamp {
        -int brightness
        -String scheduledTime
        +displayStatus()
    }
    class Thermostat {
        -double temperature
        -String scheduledTime
        +displayStatus()
    }
    class MotionSensor {
        -boolean motionDetected
        +detectMotion()
        +clearMotion()
        +displayStatus()
    }
    class SmartHome {
        -List~SmartDevice~ devices
        +addDevice(SmartDevice device)
        +displayAllDevices()
        +turnOffAllDevices()
        +scheduleDevice(Schedulable device, String time)
    }
    class App {
        -String appName
        -String version
        +run()
    }
    class MyPhone {
        -ArrayList~App~ apps
        +installApp(App app)
        +startApp(String appName)
    }
    class SmartHomeApp {
        -SmartHome home
        +run()
        +turnOn(int deviceNumber)
        +turnOff(int deviceNumber)
        +turnOffAll()
        +changeBrightness(int deviceNumber, int brightness)
        +changeTemperature(int deviceNumber, double temperature)
        +schedule(int deviceNumber, String time)
    }
    class MorningDemo {
        +main(String[] args)
    }
```

## Kort forklaring av modellen

`SmartDevice` samler navn og på/av-status, mens `Lamp`, `Thermostat` og `MotionSensor` viser hver sin typespesifikke status. `SmartHome` lagrer enhetene som `SmartDevice`-objekter og kan vise en samlet oversikt eller slå dem av med én handling. Bare lampen og termostaten implementerer `Schedulable` og kan lagre planlagte tider. `MyPhone` installerer apper, og `SmartHomeApp` arver fra `App` og bruker det samme `SmartHome`-objektet for å styre enhetene. `MorningDemo` oppretter hjemmet og telefonen og viser hvordan enhetene brukes gjennom appen fra morgen til avreise.