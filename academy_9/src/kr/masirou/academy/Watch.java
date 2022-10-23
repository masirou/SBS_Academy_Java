package kr.masirou.academy;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Watch extends JFrame {

    public Watch() {

        setTitle("시계 프로그램");
        addTime();
        frameInit();


    }



    protected void frameInit() {
        setVisible(true);
        setSize(500, 150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        setLayout(null);
    }
    private void addTime() {
        Time time = new Time("yyyy년 MM월 dd일 hh시 mm분 ss초");
        time.setBounds(0, 45, 500, 20);
        this.add(time);
    }

//        JLabel label = new JLabel();
//
//        add(label);
//        label.setHorizontalAlignment(JLabel.CENTER);
//        label.setBounds(0,45,500,20);
//        label.setText("현재 시간 : ");
//        label.setFont(new Font("Arial Rounded MT", Font.BOLD, 15));
//
//        while(true) {
//            Date date = new Date();
//            label.setText("현재 시간 : "  + format.format(date));
//        }


}
