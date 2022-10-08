import javafx.scene.paint.Stop;

import java.util.Scanner;

enum ProgrammingSkill {
    JAVA("자바"),
    C,
    CPP("C++"),
    CS("C#"),
    PYTHON("파이썬"),
    RUBY("루비"),
    NONE("알 수 없어");
    private String label;
    ProgrammingSkill() {
        label = this.name();
    }
    ProgrammingSkill(String label) {
       this.label = label;
    }
    public String getLabel() {
        return label;
    }
}
interface info {
    public void printInfo();

}
abstract class person {
    private String type;
    protected info info;

    public person(String type) {
        this.type = type;

    }
    public void printPerson() {
        System.out.println("이 " + type +"는");
        info.printInfo();
    }


}

class ProgrammerPerson extends person{

    public ProgrammerPerson(ProgrammerInfo info) {
        super("프로그래머");
        this.info = info;
    }


}


class StudentPerson extends person{

    public StudentPerson(StudentInfo info) {
        super("학생");
        this.info = info;
    }

}
class StudentInfo implements info {
    private int  grade;


    public StudentInfo(int grade) {
        this.grade = grade;
    }
    @Override
    public void printInfo() {
        System.out.println(grade + "학년 입니다");

    }
}

class ProgrammerInfo implements info{
    private ProgrammingSkill skill;
    @Override
    public void printInfo() {
        System.out.println(skill.getLabel() + "를 알고 잇습니다");
    }

    public ProgrammerInfo(ProgrammingSkill skill) {
        this.skill = skill;

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("프로그래밍 언어를 입력하세요");
        String line = scanner.nextLine();
        ProgrammingSkill skill;
        try {
            skill = ProgrammingSkill.valueOf(line);
        } catch (Exception e) {
            skill = ProgrammingSkill.NONE;

        }

        person pPerson = new ProgrammerPerson(new ProgrammerInfo(skill));

        person sPerson = new StudentPerson(new StudentInfo(3));


        pPerson.printPerson();
        sPerson.printPerson();



        for(ProgrammingSkill pSkill : ProgrammingSkill.values()) {
            System.out.println(pSkill);
        }
    }
}