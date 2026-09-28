# MySmartHome

Et lite Java-prosjekt som demonstrerer smarte enheter i ett hjem, styrt både direkte og via en app på `MyPhone`. Hovedprogrammet viser en morgen der lys og varme justeres før alle enhetene slås av ved avreise.



## Hva demoen viser

Morgen-demoen oppretter to lamper, én termostat og én bevegelsessensor i samme hjem. Appen installeres på telefonen, lagrer ulike planlagte tider for lys og varme og brukes til å slå på enheter, endre lysstyrke og temperatur samt slå av alle ved avreise. Status før og etter handlingene skrives ut i terminalen. Planlagte tider lagres som informasjon; programmet utfører ikke automatisk handlinger når klokkeslettene inntreffer.

## Prosjektstruktur

```text
mysmarthome/
├── README.md
├── docs/                  # Oppgavetekst
└── src/
    └── mysmarthome/       # Smartenheter, hjem og interaktiv demo
        └── myphone/       # Telefon, app og telefon-/morgen-demoer
```

Kompilerte filer havner i den Git-ignorerte mappen `out/`.

## UML-klassediagram

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
