package kr.masirou;

import kr.masirou.db.DataBaseManager;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        DataBaseManager.getInstance().setUp();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("이름을 입력하세요 : ");
            String name = sc.nextLine();
            System.out.printf("나이를 입력하세요 : ");
            int age = sc.nextInt();
            sc.nextLine();
            PersonDTO person = DataBaseManager.getInstance().getPerson(name);
            if(person == null) {
                System.out.println("새로운 정보를 등록합니다");
                DataBaseManager.getInstance().setPerson(name, age);
            } else {
                if(person.getAge() != age) {
                    System.out.println("나이를 업데이트 하겠습니다");
                } else  {
                    System.out.println("정보가 일치합니다");
                }
            }



        }
    }
}