import java.util.Scanner;

public class DrawATree {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String arg[]) {
        System.out.print("Hello what's your name?\nEnter Name: ");
        String name = scanner.nextLine();
        boolean tryAgain;
        do {
            tryAgain = false;
            System.out.print("Welcome " + name + "!! Let's draw together! :)\nPlease Enter A Number (3-50): ");
            int number = Integer.parseInt(scanner.nextLine());
            drawTree(number);

            System.out.println(name + "s Tree :)\n" + (number<100? "But...\nOh!\nIt's only half of it..." : (number>=500?"Why would you want to draw such a big tree??\nNow think about the other half..." : "Well that one is pretty big...\n")));
            System.out.print("Would you like to draw an other half of a tree?\nYes/No:");
            String userInput = scanner.nextLine();
            if(userInput.equalsIgnoreCase("yes")){
                tryAgain = true;
            }
        } while (tryAgain);
    }

    private static void drawTree(int number){
        for (int i = 0; i <= number; i++) {
            System.out.println("*".repeat(i));
        }

        System.out.println(number>3? number%2==0? "##\n".repeat(2) : "###\n".repeat(3) : "#\n");
    }
}

