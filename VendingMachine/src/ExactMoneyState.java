public class ExactMoneyState extends State{

    public ExactMoneyState(VMachine vm) {
        super(vm);
    }

    @Override
    void action() {
        deliver();
        vm.setReceivedMoney(0);
        changeState(new WaitingState(vm));
    }
}
