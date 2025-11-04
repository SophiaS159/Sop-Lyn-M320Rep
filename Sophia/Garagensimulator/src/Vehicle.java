public abstract class Vehicle {
    private int id;
    private String plateNumber;
    private String color;
    private String model;
    private String brand;

    protected Vehicle(int id, String plateNumber, String color, String model, String brand) {
        this.id = id;
        this.plateNumber = plateNumber;
        this.color = color;
        this.model = model;
        this.brand = brand;
    }

    // --- Getter ---
    public String getPlateNumber() { return plateNumber; }
    protected String getBrand() { return brand; } // Subklassen dürfen das nutzen
    public String getColor() { return color; }
    public String getModel() { return model; }
    public int getId() { return id; }

    // --- Setter / Update Methoden ---
    public void repaint(String newColor) {
        this.color = newColor;
        System.out.println("Vehicle repainted to: " + newColor);
    }

    public void changePlate(String newPlate) {
        this.plateNumber = newPlate;
    }

    public void changeModel(String newModel) {
        this.model = newModel;
    }

    // --- Polymorphe Methode: Jede Subklasse berechnet anders ---
    public abstract double berechneReparaturkosten();

    // --- Überladene Variante (Overloading) ---
    public double berechneReparaturkosten(boolean premiumService) {
        double base = berechneReparaturkosten();
        return premiumService ? base * 1.2 : base;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - " + brand + " (" + model + ") ["
                + plateNumber + ", " + color + "]";
    }
}
