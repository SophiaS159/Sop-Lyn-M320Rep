import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Schedule {
    private List<Passenger> passengerList;
    private List<Flight> flightList;
    Scanner scanner = new Scanner(System.in);

    public Schedule(){
        passengerList = new ArrayList<>();
        flightList = new ArrayList<>();

        passengerList.add(new Passenger("Anna", "Müller"));
        passengerList.add(new Passenger("Lukas", "Schneider"));
        passengerList.add(new Passenger("Sophie", "Wagner"));
        passengerList.add(new Passenger("Jonas", "Becker"));
        passengerList.add(new Passenger("Laura", "Fischer"));

        flightList.add(new Flight("L123F", LocalDate.of(2014, 11, 12), LocalTime.of(11, 25, 42)));
        flightList.add(new Flight("A456B", LocalDate.of(2016, 5, 8), LocalTime.of(9, 10, 15)));
        flightList.add(new Flight("C789X", LocalDate.of(2019, 3, 22), LocalTime.of(17, 45, 30)));
        flightList.add(new Flight("D321Z", LocalDate.of(2022, 7, 19), LocalTime.of(6, 55, 5)));
    }

    public void navigation(){
        System.out.println("Welcome to the schedule!");
        while (true){
            int input = 0;
            System.out.println("""
                    Schedule:
                    1.) Print Departures
                    2.) Print Flights
                    3.) Print Passengers
                    4.) Register New Passenger
                    5.) Add Passenger To Flight
                    6.) Remove Passenger From Flight
                    7.) Exit
                    """);
            input = scanner.nextInt();
            scanner.nextLine();

            switch (input){
                case 1:
                    System.out.println("Departures:");
                    for (Flight f : flightList) {
                        System.out.println("Flight " + f.getName() + " departures at " + f.getDepartureDate() + " at " + f.getDepartureTime());
                    }
                    break;
                case 2:
                    System.out.println("Flights:");
                    for (Flight f : flightList) {
                        System.out.println(f.getName() + ":\ndepartures at " + f.getDepartureDate() + " at " + f.getDepartureTime() + "\nPassenger:");
                        f.printPassengerList();
                    }
                    break;
                case 3:
                    System.out.println("Passenger:");
                    for (Passenger p : passengerList) {
                        System.out.println(p.getFirstName()+" "+p.getLastName());
                    }
                    break;
                case 4:
                    System.out.print("Please enter:\nFirst Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();
                    passengerList.add(new Passenger(firstName,lastName));
                    break;
                case 5:
                    String flightName;
                    Flight flight;
                    do {
                        System.out.print("Please enter the name of the flight: ");
                        flightName = scanner.nextLine();
                        flight = findFlightInList(flightName);
                        if (flight == null) {
                            System.out.println("Flight not found. Try again.");
                        }
                    } while (flight == null);

                    System.out.print("Passenger First Name: ");
                    String passengerFirstName = scanner.nextLine();
                    System.out.print("Passenger Last Name: ");
                    String passengerLastName = scanner.nextLine();

                    Passenger passengerToAdd = null;
                    for (Passenger p : passengerList) {
                        if (p.getFirstName().equals(passengerFirstName) && p.getLastName().equals(passengerLastName)) {
                            passengerToAdd = p;
                            break;
                        }
                    }

                    if (passengerToAdd == null) {
                        System.out.println("Passenger not found. Please register first.");
                    } else {
                        flight.addPassenger(passengerToAdd);
                        System.out.println("Passenger added successfully to flight " + flight.getName());
                    }
                    break;
                case 6:
                    do {
                        System.out.print("Please enter the name of the flight: ");
                        flightName = scanner.nextLine();
                        flight = findFlightInList(flightName);
                        if (flight == null) {
                            System.out.println("Flight not found. Try again.");
                        }
                    } while (flight == null);

                    System.out.print("Passenger First Name: ");
                    String firstNamePassenger = scanner.nextLine();
                    System.out.print("Passenger Last Name: ");
                    String lastNamePassenger = scanner.nextLine();

                    Passenger passengerToRemove = null;
                    for (Passenger p : flight.getPassengerList()) {
                        if (p.getFirstName().equals(firstNamePassenger) && p.getLastName().equals(lastNamePassenger)) {
                            passengerToRemove = p;
                            break;
                        }
                    }

                    if (passengerToRemove == null) {
                        System.out.println("Passenger not found. Try again.");
                    } else {
                        flight.removePassenger(passengerToRemove);
                        System.out.println("Passenger removed successfully from flight " + flight.getName());
                    }
                    break;
                case 7:
                    System.out.println("Logging out...\nHave a nice day.");
                    System.exit(0);
            }
        }
    }

    private Flight findFlightInList(String name){
        for (Flight f : flightList){
            if (f.getName().equals(name)){
                return f;
            }
        }
        return null;
    }
}
