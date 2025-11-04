import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String name;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private List<Passenger> passengerList;

    public Flight(String name, LocalDate departureDate, LocalTime departureTime){
        this.name = name;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        passengerList = new ArrayList<>();
    }

    public void printPassengerList(){
        for(Passenger p : passengerList){
            System.out.println(p.getFirstName()+" "+p.getLastName());
        }
        System.out.println("\n");
    }

    public void addPassenger(Passenger passenger){
        passengerList.add(passenger);
    }

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
