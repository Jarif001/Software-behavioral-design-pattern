import java.util.Scanner;

public class PremUser extends User{

    Scanner scanner;

    public PremUser(Server server, String name, String type) {
        super(server, name, type);
        scanner = new Scanner(System.in);
    }

    @Override
    public void notifyMe() {
        Server abcServer = getAbcServer();
        System.out.println();
        System.out.println("Premium User");
        if(abcServer.getPrevState() == 1 && abcServer.getCurrentState() == 2){//1 Operational, 2 partial, 3 fullDown
            System.out.println("From Server: Enter your choice");
            System.out.println("1) Service from 2 servers?");
            System.out.println("2) Service from 1 server(DEF)?");
            while(true){
                int choice = scanner.nextInt();
                if(choice == 1){
                    setState(2);//Partial down
                    System.out.println("Using service from 2 servers...");
                    break;
                }
                else if(choice == 2){
                    setState(3);//ABC fully down(Taking DEF)
                    System.out.println("Using service from DEF server");
                    break;
                }
                else{
                    System.out.println("Invalid choice");
                }
            }
        }
        else if(abcServer.getPrevState() == 1 && abcServer.getCurrentState() == 3){
            setState(3);
            System.out.println("Service is now provided by their partner DEF company");
        }
        else if(abcServer.getPrevState() == 2 && abcServer.getCurrentState() == 1){
            setState(1);
            System.out.println("Service from ABC server");
        }
        else if (abcServer.getPrevState() == 2 && abcServer.getCurrentState() == 3) {
            if(getState() == 2){
                System.out.println("All services are shifted to the server of DEF company");
                setState(3);
            }
        }
        else if(abcServer.getPrevState() == 3 && abcServer.getCurrentState() == 1){
            setState(1);
            System.out.println("Service from ABC server");
        } else if (abcServer.getPrevState() == 3 && abcServer.getCurrentState() == 2) {
            setState(2);
            System.out.println("Service from ABC, DEF servers");
        }
    }

    @Override
    public void unregister() {
        getAbcServer().unregister(this);
    }
}
