package kr.masirou.academy;

import kr.masirou.academy.entity.OverlapException;
import kr.masirou.academy.entity.Person;
import kr.masirou.academy.entity.School;
import kr.masirou.academy.entity.SchoolType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws OverlapException {
        School school = new School("테스트", SchoolType.ELE);
        Person person1 = new Person("Masirou", 13);
        Person person2 = new Person("siro", 8);
        school.AddPerson(person1);
        school.AddPerson(person1);




        school.PrintStudent();
    }
}