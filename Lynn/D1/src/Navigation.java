import java.util.Scanner;

public class Navigation {
    private Library library;
    Scanner scanner = new Scanner(System.in);
    public void navigation(String email, String password){
        library = new Library(email,password);
        String navAction[] = {"Show", "Add", "Edit", "Delete", "Logout And End Application", "Change User"};
        String navShow[] = {"All Users","All Devices", "Detailed User", "Detailed Device", "Back"};
        String navAdd[] = {"New User", "New Device", "Back"};
        String navEdit[] = {"User","Device", "Back"};
        String navDelete[] = {"User", "Device", "Back"};
        do {
            boolean back = true;
            switch (printNav(navAction)) {
                case 1:
                    while(back) {
                        switch (printNav(navShow)) {
                            case 1:
                                library.showAllPersons();
                                break;
                            case 2:
                                library.showAllDevices();
                                break;
                            case 3:
                                System.out.print("Please Enter The Index Number: ");
                                library.detailedPerson(scanner.nextInt());
                                break;
                            case 4:
                                System.out.print("Please Enter The Index Number: ");
                                library.detailedDevice(scanner.nextInt());
                                break;
                            case 5:
                                back=false;
                                break;
                            default:
                                System.out.println("Error: This Action Is Not Possible!");
                                break;
                        }
                    }
                    break;
                case 2:
                    while (back) {
                        switch (printNav(navAdd)) {
                            case 1:
                                library.addPerson();
                                break;
                            case 2:
                                System.out.print("Please Enter An Index Number Of A User: ");
                                library.addDevice(scanner.nextInt());
                                break;
                            case 3:
                                back=false;
                                break;
                            default:
                                System.out.println("Error: This Action Is Not Possible!");
                                break;
                        }
                    }
                    break;
                case 3:
                    while (back) {
                        switch (printNav(navEdit)) {
                            case 1:
                                System.out.print("Please Enter The Index Number: ");
                                library.editPerson(Integer.parseInt(scanner.nextLine()));
                                break;
                            case 2:
                                System.out.print("Please Enter The Index Number: ");
                                library.editDevice(Integer.parseInt(scanner.nextLine()));
                                break;
                            case 3:
                                back=false;
                                break;
                            default:
                                System.out.println("Error: This Action Is Not Possible!");
                                break;
                        }
                    }
                    break;
                case 4:
                    while (back){
                        switch (printNav(navDelete)) {
                            case 1:
                                System.out.print("Please Enter The Index Number: ");
                                library.deletePerson(Integer.parseInt(scanner.nextLine()));
                                break;
                            case 2:
                                System.out.print("Please Enter The Index Number: ");
                                library.deleteDevice(Integer.parseInt(scanner.nextLine()));
                                break;
                            case 3:
                                back=false;
                                break;
                            default:
                                System.out.println("Error: This Action Is Not Possible!");
                                break;
                        }
                    }
                    break;
                case 5:
                    System.exit(0);
                case 6:
                    return;
                default:
                    System.out.println("Error: This Action Is Not Possible!");
                    break;
            }
        }while (true);

    }

    private int printNav(String navList[]){
        System.out.print("\n");
        for (int i = 0; i < navList.length; i++) {
            System.out.println(i+1+".) "+navList[i]);
        }
        System.out.print("Enter: ");
        return scanner.nextInt();
    }
}
