public abstract class State {

    protected VMachine vm;//context

    public State(VMachine vm){
        this.vm = vm;
    }

    public void changeState(State state){
        vm.changeState(state);
    }

    void deliver(){
        System.out.println(vm.getProduct().getName() + " has been delivered");
        vm.getProduct().decreaseQuantity(1);
    }

    abstract void action();

}
