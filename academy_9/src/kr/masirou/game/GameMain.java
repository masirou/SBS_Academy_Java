package kr.masirou.game;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class GameMain extends JFrame {
    public GameMain() {
        super("원 피하기 게임");
        this.setSize(400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        JButton button = new JButton("Start");
        button.setVisible(true);
        button.setBounds(300, 0, 100, 30);
        add(button);

        JButton button2 = new JButton("Stop");
        button2.setVisible(true);
        button2.setBounds(300, 30, 100, 30);
        add(button2);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D td = (Graphics2D) g;
        td.setColor(new Color(142,210,250));
        Rectangle2D.Float rect = new Rectangle2D.Float(30.0f, 50.0f, 250.0f, 300.0f);
        td.fill(rect);

        Ellipse2D.Float elli = new Ellipse2D.Float(30.0f, 50.0f, 25.0f, 25.0f);
        td.setColor(Color.WHITE);
        td.fill(elli);
    }
}
