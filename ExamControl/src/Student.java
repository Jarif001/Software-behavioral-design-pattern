public abstract class Student extends Person{

    String name;
    int id;
    int mark;

    public Student(String name, int id, Mediator ec){
        super(ec);
        this.name = name;
        this.id= id;
    }

    public String getName(){
        return name;
    }

    public int getMark() {
        return mark;
    }

    public int getId() {
        return id;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void reExamineReq(){
        String msg = "From Student id - " + id + ": Re-examine request sent form student id " + id;
        System.out.println(msg);
        mediator.reExamine(this.id);
        System.out.println();
    }

    public void printTheMark(){
        System.out.println("From Student id " + id + ": Mark - " + mark);
    }

    public void notifyMe(String msg){
        System.out.println("Student id - " + id + " gets a message : " + msg);
    }

}
