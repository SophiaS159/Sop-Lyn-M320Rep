public class Motorcycle extends Vehicle {
    public Motorcycle(int id, String plateNumber, String color, String model, String brand) {
        super(id, plateNumber, color, model, brand);
    }

    @Override
    public double berechneReparaturkosten() {
        return 250.0;
    }
}
