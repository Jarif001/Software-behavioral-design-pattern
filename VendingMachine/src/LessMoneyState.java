public class LessMoneyState extends State{

    public LessMoneyState(VMachine vm) {
        super(vm);
    }

    @Override
    public void deliver() {

    }

    @Override
    void action() {
        int extraNeeded = vm.getProduct().getPrice() - vm.getReceivedMoney();
        System.out.println("Extra " + extraNeeded + " taka is needed");
        changeState(new WaitingState(vm));
    }
}
