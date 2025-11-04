public abstract class Action {
    private String name;

    public Action(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Every action must define how it is executed
    public abstract void execute(User user, Library library);
}
