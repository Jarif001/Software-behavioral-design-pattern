public class ExcessMoneyState extends State{

    public ExcessMoneyState(VMachine vm) {
        super(vm);
    }

    @Override
    void action() {
        int excessMoney = vm.getReceivedMoney() - vm.getProduct().getPrice();
        System.out.println("Taka " + excessMoney + " has been returned");
        deliver();
        vm.setReceivedMoney(0);
        changeState(new WaitingState(vm));
    }
}
