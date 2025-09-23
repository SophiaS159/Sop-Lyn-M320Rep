public class Vehicle {
    private int id;
    private String plateNumber;
    private String color;
    private String model;
    private String brand;
    private String type;

    public Vehicle(int id, String plateNumber, String color, String model, String type, String brand) {
        this.id = id;
        this.plateNumber = plateNumber;
        this.color = color;
        this.model = model;
        this.type = type;
        this.brand = brand;
    }

    // --- Update methods ---
    public void repaint(String newColor) {
        this.color = newColor;
    }

    public void changePlate(String newPlate) {
        this.plateNumber = newPlate;
    }

    public void changeModel(String newModel) {
        this.model = newModel;
    }

    public String getPlateNumber() { return plateNumber; }

    @Override
    public String toString() {
        return "____Vehicle____\n" +
                "Plate: " + plateNumber + '\n' +
                "Color: " + color + '\n' +
                "Brand: " + brand + '\n' +
                "Model: " + model + '\n' +
                "Vehicle Type: " + type + '\n' +
                "_______________";
    }
}
