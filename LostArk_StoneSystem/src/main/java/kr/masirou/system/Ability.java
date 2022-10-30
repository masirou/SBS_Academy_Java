package kr.masirou.system;

import kr.masirou.util.Percent;

import java.util.Random;

public class Ability {

    private int index;
    private boolean[] b;
    public Ability() {
        index = 0;
        b = new boolean[10];
    }

    public int getCount() {
        int count = 0;
        for(boolean bool : b) {
            if (bool) count++;
        }
        return count;
    }

    public boolean ClickAble() {
        return index != b.length;
    }
    public void Click(Percent percent) {
        boolean result = isSuccess(percent.getPercent());
        b[index++] = result;
        if(result) percent.success();
        else percent.fail();
    }


    public boolean isSuccess(int percent) {
        Random random = new Random();
        double randomNumber = random.nextDouble();
        return (percent/ 100.0) > randomNumber;


    }
    public String getLabel() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < b.length; i++) {
            sb.append("  [  " + (i < index ? (b[i]) ? "O" : "X" : " ") + "  ]  ");
        }
        sb.append(getCount());
        return sb.toString();
    }
    public void printInfo() {
        for(int i = 0; i < b.length; i++) {
            System.out.print("[" + (i < index ? (b[i]) ? "O" : "X" : " ") + "] ");



            }
        System.out.println(getCount());
    }

}
