public class Main {
    public static void main(String[] args) {

        Product productA = new ProductA("ProductA", 100, 5);
        VMachine vm1 = new VM(productA);

        while(true){
            vm1.getState().action();
            if(vm1.exit() == 1){
                break;
            }
        }

    }
}