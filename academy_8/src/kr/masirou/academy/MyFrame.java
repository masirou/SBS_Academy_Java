package kr.masirou.academy;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MyFrame extends JFrame {
    private long time = 0 ;
    private JLabel label;

    public MyFrame(int x, int y) {
        this(x, y,null);
    }




    public MyFrame(int x, int y, String name) {
        super(name);
        setVisible(true);
        setSize(x, y);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        JPanel panel = new JPanel();
        this.add(panel);
        panel.setBackground(Color.WHITE);
        JLabel label = new JLabel("TTTT");

        panel.add(label);
        panel.addMouseListener(new MyMouseListener(this));
        try {
            Random random = new Random();
            Thread.sleep(1000*(random.nextInt(11)+1));
            time = System.currentTimeMillis();
            panel.setBackground(Color.BLUE);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void click() {
        long clickedTime = System.currentTimeMillis();

        if (time == 0) {
            System.out.println("AA");

        } else {
            long laps = clickedTime - time;
            label.setText("성공" + laps);
        }
    }


}
