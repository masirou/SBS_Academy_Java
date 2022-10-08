import java.util.Random;
import java.util.Scanner;

public class Main_3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        double percent = sc.nextDouble() / 100.0;
        int T = 0;
        int F = 0;
        for(int i = 0; i < count; i++) {
            if (percent(percent)){
                System.out.println("성공");
                T++;


            }else {
                System.out.println("실패");
                F++;
            }
        }
        percent(0.0);
        System.out.printf("성공 : %d 실패 : %d",T, F);
    }
    public static boolean percent(double per) {
        Random random = new Random();
        double randomNum = random.nextDouble();
        if(per >= 1) {
            return true;
        } else if (per <= 0 ) {
            return false;
        } else {
            return randomNum <= per;
        }
    }
}
