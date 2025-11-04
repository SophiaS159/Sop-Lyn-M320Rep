import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * Represents a terminal schedule system that manages flights and passengers.
 * Provides functions for viewing and modifying flight and passenger data.
 */
public class Schedule {
    private final List<Passenger> passengerList; // List of all existing passengers
    private final List<Flight> flightList;       // List of all flights
    Scanner scanner = new Scanner(System.in);

    /**
     * Creates a new schedule with given test data.
     */
    public Schedule(){
        passengerList = new ArrayList<>();
        flightList = new ArrayList<>();

        //Test passengers
        passengerList.add(new Passenger("Anna", "Müller"));
        passengerList.add(new Passenger("Lukas", "Schneider"));
        passengerList.add(new Passenger("Sophie", "Wagner"));
        passengerList.add(new Passenger("Jonas", "Becker"));
        passengerList.add(new Passenger("Laura", "Fischer"));

        //Test flights
        flightList.add(new Flight("L123F", LocalDate.of(2014, 11, 12), LocalTime.of(11, 25, 42)));
        flightList.add(new Flight("A456B", LocalDate.of(2016, 5, 8), LocalTime.of(9, 10, 15)));
        flightList.add(new Flight("C789X", LocalDate.of(2019, 3, 22), LocalTime.of(17, 45, 30)));
        flightList.add(new Flight("D321Z", LocalDate.of(2022, 7, 19), LocalTime.of(6, 55, 5)));
    }

    /**
     * Displays a terminal menu for interacting with flights and passengers.
     * The menu runs continuously until manually exited.
     */
    public void navigation(){
        System.out.println("Welcome to the terminal (schedule)!");
        while (true){
            System.out.println("""
                    Terminal (Schedule):
                    1.) Print Departures
                    2.) Print Flights
                    3.) Print Passengers
                    4.) Register New Passenger
                    5.) Add Passenger To Flight
                    6.) Remove Passenger From Flight
                    7.) Exit
                    """);
            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input){
                case 1: //Prints all flight departures
                    System.out.println("Departures:");
                    for (Flight f : flightList) {
                        System.out.println("Flight " + f.getName() + " departures at " + f.getDepartureDate() + " at " + f.getDepartureTime());
                    }
                    break;

                case 2: //Prints all flights and there passengers
                    System.out.println("Flights:");
                    for (Flight f : flightList) {
                        System.out.println(f.getName() + ":\nDepartures at " + f.getDepartureDate() + " at " + f.getDepartureTime() + "\nPassenger:");
                        f.printPassengerList();
                    }
                    break;

                case 3://Prints all existing passengers
                    System.out.println("Passenger:");
                    for (Passenger p : passengerList) {
                        System.out.println(p.getFirstName()+" "+p.getLastName());
                    }
                    break;

                case 4: //Registers a new passenger
                    System.out.print("Please enter:\nFirst Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();
                    passengerList.add(new Passenger(firstName,lastName));
                    break;

                case 5: //Adds an existing passenger to a specific flight
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
                        flight.addPassenger(passengerToAdd);//Adding passenger to flight
                        System.out.println("Passenger added successfully to flight " + flight.getName());
                    }
                    break;

                case 6: //Removes a passenger from a flight
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
                        flight.removePassenger(passengerToRemove); //Removing passenger from flight
                        System.out.println("Passenger removed successfully from flight " + flight.getName());
                    }
                    break;
                case 7:
                    System.out.println("Logging out...\nHave a nice day.");
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    /**
     * Finds a flight in the list by its name.
     * @param name The name/code of the flight ex. L123F
     * @return The Flight object if found, otherwise null.
     */
    private Flight findFlightInList(String name){
        for (Flight f : flightList){
            if (f.getName().equals(name)){
                return f;
            }
        }
        return null;
    }
}
