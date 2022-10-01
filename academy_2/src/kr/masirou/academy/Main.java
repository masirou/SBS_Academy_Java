package kr.masirou.academy;
import kr.masirou.academy.calc.*;

public class Main {
    public static void main(String[] args) {
        Calc[] cals = new Calc[3];
        try{
            System.out.println(cals[0].calc(10,20));
        } catch (Exception NullPointerException) {
             cals[0] = new Add();
            System.out.println("┌────────────────────────────────────────┐");
            System.out.println("│              ** Error **               │");
            System.out.println("└────────────────────────────────────────┘");
        } finally {
            System.out.println(cals[0].calc(10, 50));
        }
    }
}