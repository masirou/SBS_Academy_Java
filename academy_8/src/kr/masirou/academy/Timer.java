package kr.masirou.academy;
//
//public class Timer extends Thread{
//    private int waitSec;
//
//
//
//    public Timer(int waitSec) {
//        this.waitSec = waitSec;
//    }
//    @Override
//    public void run() {
//        long start = System.currentTimeMillis();
//
//        while (System.currentTimeMillis() - start < (waitSec * 1000)) {
//
//        }
//        System.out.println("시간이 됐습니다");
//
//    }
//}
public class Timer implements Runnable{
    private int waitSec;



    public Timer(int waitSec) {
        this.waitSec = waitSec;
    }
    @Override
    public void run() {
        long start = System.currentTimeMillis();

        while (System.currentTimeMillis() - start < (waitSec * 1000)) {

        }
        System.out.println("시간이 됐습니다");

    }
}
