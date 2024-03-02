import java.util.ArrayList;

public class ABCServer extends Server{

    private String name;
    private int prevState;
    private int state;
    private ArrayList<User> users;

    public ABCServer(String name){
        state = 1;
        users = new ArrayList<>();
    }

    @Override
    public void register(User user){
        this.users.add(user);
    }
    @Override
    public void unregister(User user){
        this.users.remove(user);
    }

    @Override
    public void notifyUsers(){
        for(User user : users){
            user.notifyMe();
        }
    }

    @Override
    public void setState(int state){
        prevState = this.state;
        this.state = state;
        notifyUsers();
    }

    @Override
    public int getCurrentState() {
        return state;
    }

    @Override
    public void getMsg(String s) {
        System.out.println(s);
    }

    @Override
    public int getPrevState() {
        return prevState;
    }
}
