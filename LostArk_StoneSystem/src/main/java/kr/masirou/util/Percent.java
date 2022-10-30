package kr.masirou.util;

public class Percent {
     private static final int MIN_PERCENT = 25;
     private static final int MAX_PERCENT = 75;
     private int percent;
     public Percent() {
         percent = 75;

     }
     public void success() {

         if(percent > MIN_PERCENT) percent-=10;

     }
     public void fail() {
         if(percent < MAX_PERCENT) percent+=10;
     }

    public int getPercent() {
        return percent;
    }
}
