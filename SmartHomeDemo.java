package mysmarthome;

import java.util.Scanner;

public class SmartHomeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Lamp lampe1 = new Lamp("Lampe 1", 40);
        Lamp lampe2 = new Lamp("Lampe 2", 70);
        Thermostat termostat1 = new Thermostat("Termostat 1", 19.5);

        SmartHome home = new SmartHome();
        home.addDevice(lampe1);
        home.addDevice(lampe2);
        home.addDevice(termostat1);

        while (true) {
            System.out.println("\n=== SMART HOME MENY ===");
            home.displayAllDevices();

            System.out.println((home.getDeviceCount() + 1) + ". Slå på alle enheter");
            System.out.println((home.getDeviceCount() + 2) + ". Slå av alle enheter");
            System.out.println((home.getDeviceCount() + 3) + ". Avslutt");
            System.out.print("Velg en enhet: ");

            int valg;
            try {
                valg = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Du må skrive inn et nummer.");
                continue;
            }

            if (valg == home.getDeviceCount() + 1) {
                home.turnOnAllDevices();
                System.out.println("Alle enheter er slått på.");
                continue;
            }

            if (valg == home.getDeviceCount() + 2) {
                home.turnOffAllDevices();
                System.out.println("Alle enheter er slått av.");
                continue;
            }

            if (valg == home.getDeviceCount() + 3) {
                System.out.println("Programmet avsluttes.");
                break;
            }

            if (valg < 1 || valg > home.getDeviceCount()) {
                System.out.println("Ugyldig valg. Prøv igjen.");
                continue;
            }

            SmartDevice valgtEnhet = home.getDevice(valg - 1);

            if (valgtEnhet instanceof Lamp) {
                Lamp valgtLampe = (Lamp) valgtEnhet;

                while (true) {
                    System.out.println("\n=== MENY FOR " + valgtLampe.getName().toUpperCase() + " ===");
                    System.out.println("1. Endre lysstyrke");
                    System.out.println("2. Slå på/av");
                    System.out.println("3. Vis status");
                    System.out.println("4. Gå tilbake");
                    System.out.print("Velg: ");

                    int lampValg;
                    try {
                        lampValg = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Du må skrive inn et nummer.");
                        continue;
                    }

                    switch (lampValg) {
                        case 1:
                            System.out.print("Skriv inn ny lysstyrke (0-100): ");
                            try {
                                int nyLysstyrke = Integer.parseInt(scanner.nextLine());
                                valgtLampe.setBrightness(nyLysstyrke);
                                System.out.println("Lysstyrke oppdatert.");
                            } catch (NumberFormatException e) {
                                System.out.println("Ugyldig verdi. Skriv inn et heltall.");
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case 2:
                            if (valgtLampe.isOn()) {
                                home.turnOffDevice(valgtLampe);
                                System.out.println("Lampe slått av.");
                            } else {
                                home.turnOnDevice(valgtLampe);
                                System.out.println("Lampe slått på.");
                            }
                            break;

                        case 3:
                            valgtLampe.displayStatus();
                            break;

                        case 4:
                            break;

                        default:
                            System.out.println("Ugyldig valg.");
                            continue;
                    }

                    if (lampValg == 4) {
                        break;
                    }
                }

            } else if (valgtEnhet instanceof Thermostat) {
                Thermostat valgtThermostat = (Thermostat) valgtEnhet;

                while (true) {
                    System.out.println("\n=== MENY FOR " + valgtThermostat.getName().toUpperCase() + " ===");
                    System.out.println("1. Endre temperatur");
                    System.out.println("2. Slå på/av");
                    System.out.println("3. Vis status");
                    System.out.println("4. Gå tilbake");
                    System.out.print("Velg: ");

                    int thermostatValg;
                    try {
                        thermostatValg = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Du må skrive inn et nummer.");
                        continue;
                    }

                    switch (thermostatValg) {
                        case 1:
                            System.out.print("Skriv inn ny temperatur: ");
                            try {
                                double nyTemp = Double.parseDouble(scanner.nextLine());
                                valgtThermostat.setTemperature(nyTemp);
                                System.out.println("Temperatur oppdatert.");
                            } catch (NumberFormatException e) {
                                System.out.println("Ugyldig verdi. Skriv inn et tall.");
                            }
                            break;

                        case 2:
                            if (valgtThermostat.isOn()) {
                                home.turnOffDevice(valgtThermostat);
                                System.out.println("Termostat slått av.");
                            } else {
                                home.turnOnDevice(valgtThermostat);
                                System.out.println("Termostat slått på.");
                            }
                            break;

                        case 3:
                            valgtThermostat.displayStatus();
                            break;

                        case 4:
                            break;

                        default:
                            System.out.println("Ugyldig valg.");
                            continue;
                    }

                    if (thermostatValg == 4) {
                        break;
                    }
                }
            }
        }

        scanner.close();
    }
}