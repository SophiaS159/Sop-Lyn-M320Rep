public class ShowUserDataAction extends Action {
    public ShowUserDataAction() {
        super("Show my data");
    }

    @Override
    public void execute(User user, Library library) {
        user.showMyData(); // reuses your old code
    }
}
