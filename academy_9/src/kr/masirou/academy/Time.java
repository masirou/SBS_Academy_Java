package kr.masirou.academy;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time extends JLabel {
    private SimpleDateFormat format;


    public Time(String format) {
        this.format = new SimpleDateFormat(format);
        setText("현재 시간 : " + this.format.format(new Date()));
        Thread thread = new Thread(() -> {
            while(true) {
               setText("현재 시간 : " + this.format.format(new Date()));
           }
        });
        thread.start();
    }


    //Runnable 불러오고
//    @Override
//    public void run() {
//        while(true){
//            setText("현재 시간 : " + this.format.format(new Date()));
//        }
//    }

}
