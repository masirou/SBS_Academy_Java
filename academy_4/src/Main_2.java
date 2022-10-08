import com.sun.org.apache.bcel.internal.generic.GOTO;
import com.sun.org.glassfish.external.statistics.annotations.Reset;

import java.util.Random;
import java.util.Scanner;

public class Main_2 {

    public static void main(String[] args) {
        final int 가위 = 0;
        final int 바위 = 1;
        final int 보 = 2;
        Random random = new Random();
        int computerNum = random.nextInt(3);
        Scanner sc = new Scanner(System.in);

        System.out.println("|가위|바위|보|를 입력하세요");
        String player = sc.nextLine();
        int playerNum = 0;
        if(player.equals("가위")) {
            playerNum = 가위;
        } else if (player.equals("바위")) {
            playerNum = 바위;
        } else if (player.equals("보")){
            playerNum = 보;
        } else {
            System.out.println("|가위|바위|보| 중에 내세요");

        }
        System.out.println("Computer : " + (computerNum == 가위 ? "가위" : computerNum == 바위 ? "바위" : 보));
        if (playerNum == computerNum){
            System.out.println("비겼습니다");
        } else if (playerNum == 가위) {
            if (computerNum == 바위) {
                System.out.println("졌습니다");
            }
            else {
                System.out.println("이겼습니다");
            }

        } else if (playerNum == 바위) {
            if (computerNum == 보) {
                System.out.println("졌습니다");
            }
            else {
                System.out.println("이겼습니다");
            }

        } else if (playerNum == 보) {
            if (computerNum == 가위) {
                System.out.println("졌습니다");
            }
            else {
                System.out.println("이겼습니다");
            }
        }

    }
}
