import java.util.Scanner;

public class RegularUser extends User{

    Scanner scanner;

    public RegularUser(Server server, String name, String type) {
        super(server, name, type);
        scanner = new Scanner(System.in);
    }

    @Override
    public void notifyMe() {
        Server abcServer = getAbcServer();
        System.out.println();
        System.out.println("Regular User");
        if(abcServer.getPrevState() == 1 && abcServer.getCurrentState() == 2){//1 Operational, 2 partial, 3 fullDown
            System.out.println("From Server: Enter your choice");
            System.out.println("1) Continue using limited functionality");
            System.out.println("2) Pay 20$ per hour taking service of DEF(Copy your data to DEF server)");
            while(true){
                int choice = scanner.nextInt();
                if(choice == 1){
                    setState(2);//Partial down
                    System.out.println("Using limited functionality");
                    break;
                }
                else if(choice == 2){
                    setState(3);//ABC fully down(taking DEF)
                    System.out.println("Service from DEF server. Copying your data to server of DEF...");
                    break;
                }
                else{
                    System.out.println("Invalid choice");
                }
            }
        }
        else if(abcServer.getPrevState() == 1 && abcServer.getCurrentState() == 3){
            System.out.println("1) Pay 20$ per hour taking service of DEF(Copy your data to DEF server)");
            System.out.println("Anything other than 1 to full down");
            while(true){
                int choice = scanner.nextInt();
                if(choice == 1){
                    setState(3);//taking from DEF
                    System.out.println("Copying your data to server of DEF");
                    break;
                }
                else{
                    setState(3);//fully down
                    System.out.println("Server is fully down");
                }
            }
        }
        else if(abcServer.getPrevState() == 2 && abcServer.getCurrentState() == 1){
            setState(1);
            System.out.println("Total bill " + x + "tk sent for the service");
        }
        else if (abcServer.getPrevState() == 2 && abcServer.getCurrentState() == 3) {
            setState(3);
            System.out.println("Server is fully down");
        }
        else if(abcServer.getPrevState() == 3 && abcServer.getCurrentState() == 1){
            setState(1);
            System.out.println("Total bill " + x + "tk sent");
        } else if (abcServer.getPrevState() == 3 && abcServer.getCurrentState() == 2) {
            setState(2);
        }
    }

    @Override
    public void unregister() {
        getAbcServer().unregister(this);
    }
}
