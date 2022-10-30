package kr.masirou;

import kr.masirou.gui.GuiMain;
import kr.masirou.system.Stone;
import kr.masirou.system.Stone.AbilityType;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Stone stone = new Stone();

        Scanner scanner = new Scanner(System.in);
        new GuiMain(stone);

//
//        while (stone.ClickAble()) {
//            stone.printInfo();
//            System.out.print("시도 할 번호를 입력하세요 : ");
//            int input = scanner.nextInt();
//            AbilityType type = AbilityType.indexOf(input);
//            if (type == null) System.out.println("올바르지 않은 번호");
//            else stone.clickAbility(type);
//        }
//        stone.printInfo();


    }
}