public class ShowRepairCostsAction extends Action {
    public ShowRepairCostsAction() {
        super("Show repair costs of my vehicles");
    }

    @Override
    public void execute(User user, Library library) {
        System.out.println("=== Repair Costs ===");
        for (Vehicle v : user.getMyVehicles()) {
            System.out.println(v + " -> " + v.berechneReparaturkosten() + " CHF");
        }
    }
}
