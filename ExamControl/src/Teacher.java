import java.util.ArrayList;

public abstract class Teacher extends Person{

    String name;

    public Teacher(String name, Mediator ec){
        super(ec);
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int reExamine(int mark){
        System.out.println("Teacher: Script for re-examine got from exam controller office");
        int prevMark = mark;
        int prob = (int) (Math.random() * 10) % 2;
        if (prob != 0){
            double random = Math.random() * 10;
            int ran = (int)random + 1;
            int correctedMark;
            if(ran % 2 == 0){
                correctedMark = (int) (mark + (mark * (random/6.0)));
                if(correctedMark > 100){
                    correctedMark = 100;
                }
            }
            else{
                correctedMark = (int) (mark - (mark * (random/10.0)));
                if(correctedMark < 0){
                    correctedMark = 0;
                }
            }
            if(prevMark != correctedMark){
                return correctedMark;
            }

        }
        return -1;
    }

    public ArrayList<Integer> checkExamScripts(int n){
        ArrayList<Integer> marks = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int randomNum = (int) (Math.random() * 101);
            marks.add(randomNum);
        }
        String msg = "Scripts and marks of student id ";
        for(int i = 1; i <= n; i++){
            msg += i;
            if(i != n){
                msg += ",";
            }
        }
        msg += " sent to exam controller office";
        System.out.println("Teacher: " + msg);
        System.out.println();
        return marks;
    }

}
