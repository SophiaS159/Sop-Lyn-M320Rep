import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a flight with a name, departure date, time and a passenger list.
 */

public class Flight {
    private String name;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private List<Passenger> passengerList;

    /**
     * Creates a new Flight.
     * @param name The name/code of the flight. ex. D321Z
     * @param departureDate The date of departure. ex. 2001-12-03
     * @param departureTime The time of departure. ex. 12:27:11
     */

    public Flight(String name, LocalDate departureDate, LocalTime departureTime){
        this.name = name;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        passengerList = new ArrayList<>();
    }

   /**
    * Prints all passengers on the flight.
    */
    public void printPassengerList(){
        for(Passenger p : passengerList){
            System.out.println(p.getFirstName()+" "+p.getLastName()); //Tim Willi
        }
        System.out.println("\n");
    }

    /**
     * Adds a passenger to the flight.
     * @param passenger The passenger who's to be added.
     */
    public void addPassenger(Passenger passenger){
        passengerList.add(passenger);
    }

    /**
     * Removes a passenger from the flight.
     * @param passenger The passenger who's to be removed.
     */
    public void removePassenger(Passenger passenger){
        passengerList.remove(passenger);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }
}
