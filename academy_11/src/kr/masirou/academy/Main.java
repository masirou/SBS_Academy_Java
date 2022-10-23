package kr.masirou.academy;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileException, IOException {
        FileManager manager = FileManager.getInstance();
        Person person;
        String name;
        int age;


        String data = manager.getString();
        if (data == null || data.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("이름 입력 : ");
            name = sc.nextLine();
            System.out.println("나이 입력 :" );
            age = sc.nextInt();
            person = new Person(name, age);
            manager.writeString(person.toString());
        } else {
            person = new Person(data);

        }
        person.PrintInfo();


    }
}