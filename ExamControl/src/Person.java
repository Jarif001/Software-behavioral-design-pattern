public abstract class Person {

    protected Mediator mediator;
    private int id;
    public Person(Mediator mediator){
        this.mediator = mediator;
    }

    public int getId() {
        return id;
    }
}
