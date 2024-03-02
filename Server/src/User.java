public abstract class User {

    protected Server abcServer;
    protected String name;
    protected String type;
    protected int state;

    protected int x;//bill

    public User(Server server, String name, String type){
        this.abcServer = server;
        this.name = name;
        this.type = type;
        x = 500;
    }
    public void sendToServer(String msg){
        abcServer.getMsg(this.name + " (" + this.type + "): " + msg);
    }
    public abstract void notifyMe();
    public abstract void unregister();
    public void setState(int state){
        this.state = state;
    }
    public int getState(){
        return state;
    }

    public Server getAbcServer() {
        return abcServer;
    }
}
