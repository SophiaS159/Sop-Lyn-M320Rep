import ClassObj.HousePlan.House;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello java classes and objects!");
        House houseSmith = new House();

        String familyName = houseSmith.getFamilyName();
        System.out.println(familyName);
        System.out.println(houseSmith.getNumberOfRooms());
    }
}