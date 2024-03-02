import java.util.Scanner;

public class WaitingState extends State{

    Scanner scanner;
    public WaitingState(VMachine vm) {
        super(vm);
        scanner = new Scanner(System.in);
    }

    @Override
    public void deliver() {

    }

    public void action(){
        System.out.println("1) Add money to buy");
        System.out.println("2) Exit");
        int cmd = scanner.nextInt();
        scanner.nextLine();
        if(cmd == 1){
            if(vm.getProduct().getQuantity() != 0){
                System.out.println("Enter Amount");
                int enteredAmount = scanner.nextInt();
                scanner.nextLine();
                vm.increaseMoney(enteredAmount);
                if(vm.getReceivedMoney() > vm.getProduct().getPrice()){
                    vm.changeState(new ExcessMoneyState(vm));
                }
                else if(vm.getReceivedMoney() < vm.getProduct().getPrice()){
                    vm.changeState(new LessMoneyState(vm));
                }
                else{
                    vm.changeState(new ExactMoneyState(vm));
                }
            }
            else{
                System.out.println("No products available");
            }
        }
        else if(cmd == 2){
            if(vm.getReceivedMoney() > 0){
                System.out.println("Taka " + vm.getReceivedMoney() + " has been returned");
                vm.setReceivedMoney(0);
            }
            System.out.println("Exiting...");
            vm.setExit();
        }
        else{
            System.out.println("Invalid command");
        }
    }

}
