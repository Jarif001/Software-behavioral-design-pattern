import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ExamControl ec = new ExamControl();
        Teacher teacher = new ConcreteTeacher("Kuddus", ec);
        Student s1 = new ConcreteStudent("Jarif", 1, ec);
        Student s2 = new ConcreteStudent("Abir", 2, ec);
        Student s3 = new ConcreteStudent("Topu", 3, ec);
        Student s4 = new ConcreteStudent("Rahim", 4, ec);
        Student s5 = new ConcreteStudent("Hasnat", 5, ec);
        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);

        ec.setStudents(students);
        ec.setTeacher(teacher);

        System.out.println();

        ec.getExamScripts();//getting the marks from teacher
        ec.printMarks();//print the marks
        ec.correctMarks();//check and publish to students
        //printing marks from students side
        for(Student s : students){
            s.printTheMark();
        }
        System.out.println();
        //Re-examine Request
        while(true){
            System.out.println("Want to re-examine? 1 for yes and 2 for no");
            int inputId = scanner.nextInt();
            scanner.nextLine();
            if(inputId == 1){
                System.out.println("Enter your ID");
                inputId = scanner.nextInt();
                scanner.nextLine();
                if(inputId >= 1 && inputId <= students.size()){
                    students.get(inputId-1).reExamineReq();
                }
                else{
                    System.out.println("Invalid Id");
                }
            }
            else if(inputId != 2){
                System.out.println("Invalid input");
            }
            else{
                break;
            }
        }
    }
}