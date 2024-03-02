import java.util.ArrayList;

public class ExamControl extends Mediator{

    ArrayList<Student> students;
    ArrayList<Integer> marks;
    Teacher teacher;

    public void setStudents(ArrayList<Student> students){
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setMarks(ArrayList<Integer> marks) {
        this.marks = marks;
    }

    public void getExamScripts(){
        setMarks(teacher.checkExamScripts(students.size()));
    }
    @Override
    public void reExamine(int id) {
        System.out.println("Exam controller office: Re-examine request got from student id " + id);
        int newMark = teacher.reExamine(students.get(id-1).getMark());
        if(newMark == -1){
            students.get(id-1).notifyMe("(From Exam Controller Office): Your mark has not been changed");
        }
        else{
            students.get(id-1).notifyMe("(From Exam Controller Office): Your mark has been changed. Previous mark " + marks.get(id-1) + ", Corrected mark " + newMark);
            marks.set(id-1, newMark);
        }
        System.out.println();
    }

    public void printMarks(){
        System.out.println("Exam controller office: ");
        for(int i = 0; i < students.size(); i++){
            System.out.println("Student ID - " + students.get(i).getId() + ", Marks - " + marks.get(i));
        }
        System.out.println();
    }

    public void correctMarks(){
        int count = 1;
        for(int i = 0; i < students.size(); i++){
            int prevMark = marks.get(i);
            int prob = (int) (Math.random() * 10) % 3;
            if (prob != 0){
                double random = Math.random() * 10;
                int ran = (int)random + 1;
                int correctedMark;
                if(ran % 2 == 0){
                    correctedMark = (int) (marks.get(i) + (marks.get(i) * (random/6.0)));
                    if(correctedMark > 100){
                        correctedMark = 100;
                    }
                }
                else{
                    correctedMark = (int) (marks.get(i) - (marks.get(i) * (random/10.0)));
                    if(correctedMark < 0){
                        correctedMark = 0;
                    }
                }
                if(correctedMark != prevMark){
                    if(count == 1){
                        count++;
                        System.out.println("Exam Controller Office: ");
                    }
                    marks.set(i, correctedMark);
                    System.out.println("Student ID - " + students.get(i).getId() + ", previous mark - " + prevMark + ", corrected mark - " + correctedMark);
                }
            }
        }
        publishToStudents();
        System.out.println();
    }

    private void publishToStudents() {
        int i = 0;
        for(Student student : students){
            student.setMark(marks.get(i++));
        }
        System.out.println();
        System.out.println("Exam Controller Office: Marks are now published to students");
    }

}
