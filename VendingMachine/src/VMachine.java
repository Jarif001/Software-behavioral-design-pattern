public abstract class VMachine {

    private Product product;
    private int receivedMoney;
    private State state;

    int exit = 0;
    public VMachine(Product product){
        receivedMoney = 0;
        state = new WaitingState(this);
        this.product = product;
    }

    public void changeState(State state) {
        this.state = state;
    }

    public State getState(){
        return state;
    }

    public Product getProduct() {
        return product;
    }

    public int getReceivedMoney() {
        return receivedMoney;
    }

    public void setReceivedMoney(int receivedMoney) {
        this.receivedMoney = receivedMoney;
    }

    public void increaseMoney(int money){
        receivedMoney += money;
    }

    public void setExit(){
        exit = 1;
    }
    public int exit() {
        return exit;
    }
}
