import java.util.Scanner;

public class Navigation extends Library{
    Scanner scanner = new Scanner(System.in);
    public Navigation (String email, String password){
        super(email, password);
    }
    public void navigation(){
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
                                showAllPersons();
                                break;
                            case 2:
                                showAllDevices();
                                break;
                            case 3:
                                System.out.print("Please Enter The Index Number: ");
                                detailedPerson(scanner.nextInt());
                                break;
                            case 4:
                                System.out.print("Please Enter The Index Number: ");
                                detailedDevice(scanner.nextInt());
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
                                addPerson();
                                break;
                            case 2:
                                System.out.print("Please Enter An Index Number Of A User: ");
                                int myValue= scanner.nextInt();
                                addDevice(myValue);
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
                                editPerson(Integer.parseInt(scanner.nextLine()));
                                break;
                            case 2:
                                System.out.print("Please Enter The Index Number: ");
                                editDevice(Integer.parseInt(scanner.nextLine()));
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
                                deletePerson(Integer.parseInt(scanner.nextLine()));
                                break;
                            case 2:
                                System.out.print("Please Enter The Index Number: ");
                                deleteDevice(Integer.parseInt(scanner.nextLine()));
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
        try {
            return Integer.parseInt(scanner.nextLine());
        }catch (java.lang.NumberFormatException exception){
            int i = Integer.parseInt(scanner.nextLine());
            return i;
        }
    }
}
