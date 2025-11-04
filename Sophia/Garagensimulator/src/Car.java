public class Car extends Vehicle {
    public Car(int id, String plateNumber, String color, String model, String brand) {
        super(id, plateNumber, color, model, brand);
    }

    @Override
    public double berechneReparaturkosten() {
        // Beispiel: BMW = teurer, Toyota = günstiger
        return switch (getBrand().toLowerCase()) {
            case "bmw" -> 600.0;
            case "toyota" -> 400.0;
            default -> 500.0;
        };
    }
}
