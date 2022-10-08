package kr.masirou.academy.entity;

import java.util.ArrayList;
import java.util.List;

public class School {
    private String name;
    private List<Person> student;
    private SchoolType type;

    public School(String name, SchoolType type) {
        this.name = name;
        this.type = type;

        student = new ArrayList();
    }
    public boolean AddPerson(Person person) throws OverlapException {

        if(!student.contains(person)) {

            if (type.checkAge(person)) {
                student.add(person);
                return true;
            } else {
                System.out.println(person.getName()+ "는" +" 나이가 충족되지 못하거나 초과함");
                return false;
            }
        }else {
            System.out.println(person.getName() + "는 이미 입학중입니다");
            return false;
        }

    }
    public void PrintStudent() {
        System.out.println(name+type.getSchool());
        for (Person person: student) {
            System.out.println(person.getName() + " " + person.getAge() + "살");
        }

    }

}
