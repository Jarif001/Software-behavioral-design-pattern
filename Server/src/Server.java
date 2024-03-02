public abstract class Server {

    public abstract void register(User user);
    public abstract void unregister(User user);
    public abstract void setState(int state);
    public abstract void notifyUsers();
    public abstract int getPrevState();
    public abstract int getCurrentState();

    public abstract void getMsg(String s);
}
