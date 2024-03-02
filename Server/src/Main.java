import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Server abc = new ABCServer("ABC");
        User user1 = new PremUser(abc, "PremiumUser", "Premium");
        User user2 = new RegularUser(abc, "RegularUser", "Regular");

        abc.register(user1);
        abc.register(user2);

        Scanner scanner = new Scanner(System.in);
        int choice;
        while(true){
            System.out.println();
            System.out.println("Current state: (" + abc.getCurrentState() + ")");
            System.out.println("1) Operational");
            System.out.println("2) Partial Down");
            System.out.println("3) Fully down");
            System.out.println("4) Exit");
            choice = scanner.nextInt();
            if(choice == 4){
                break;
            }
            else if(choice == 1){
                abc.setState(1);
            }
            else if(choice == 2){
                abc.setState(2);
            }
            else if(choice == 3){
                abc.setState(3);
            }
            else{
                System.out.println("Invalid Input");
            }
        }

    }
}