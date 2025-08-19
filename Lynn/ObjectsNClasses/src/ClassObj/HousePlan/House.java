package ClassObj.HousePlan;

public class House {

    private String familyName;
    private String street;
    private int houseNumber;
    private int numberOfRooms;
    private double price;

    public House() {
        familyName = "";
        street = "";
        houseNumber = 0;
        numberOfRooms = 0;
        price = 0.0;
    }

    // Getters
    public String getFamilyName() {
        return familyName;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}