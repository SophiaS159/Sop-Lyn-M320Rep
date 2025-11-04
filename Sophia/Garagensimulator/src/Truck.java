public class Truck extends Vehicle {
    public Truck(int id, String plateNumber, String color, String model, String brand) {
        super(id, plateNumber, color, model, brand);
    }

    @Override
    public double berechneReparaturkosten() {
        return 800.0;
    }
}
