package kr.masirou.gui;

import kr.masirou.system.Stone;

import javax.swing.*;
import java.awt.*;
import java.util.jar.JarEntry;

public class GuiMain extends JFrame {
    private final kr.masirou.system.Stone Stone;
    private JButton[] buttons;
    private JLabel[] labels;
    private Stone stone;
    public GuiMain(kr.masirou.system.Stone stone) {
        Stone = stone;

        this.setSize(1000, 500);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.stone = Stone;
        init();
        update();
        buttonInit();
    }
    private void init() {
        labels = new JLabel[4];
        for(int i = 0; i < 4; i++) {
            labels[i] = new JLabel("label" + i);
            labels[i].setBounds(50, (100*i), 700, 50);
            labels[i].setFont(new Font("Arial", Font.BOLD, 15));

            this.add(labels[i]);

        }
        buttons = new JButton[4];
        for(int i = 0; i < 4; i++) {
            buttons[i] = new JButton("버튼");

            buttons[i].setBounds(780, 100+(100*i), 80, 35);

            this.add(buttons[i]);
        }

        labels[0].setBounds(800, 20, 150, 50);


        buttons[3].setText("리셋");


    }
    public void update() {
        labels[0].setText(stone.getPercent() + "%");
        labels[1].setText(stone.getAbility(kr.masirou.system.Stone.AbilityType.GOOD_ABILITY_1).getLabel());
        labels[2].setText(stone.getAbility(kr.masirou.system.Stone.AbilityType.GOOD_ABILITY_2).getLabel());
        labels[3].setText(stone.getAbility(kr.masirou.system.Stone.AbilityType.BAD_ABILITY).getLabel());
        if(!stone.getAbility(kr.masirou.system.Stone.AbilityType.GOOD_ABILITY_1).ClickAble()) {
            buttons[0].setEnabled(false);
        }
        if(!stone.getAbility(kr.masirou.system.Stone.AbilityType.GOOD_ABILITY_2).ClickAble()) {
            buttons[1].setEnabled(false);
        }
        if(!stone.getAbility(kr.masirou.system.Stone.AbilityType.BAD_ABILITY).ClickAble()) {
            buttons[2].setEnabled(false);
        }


    }
    private void buttonInit() {
        buttons[0].addActionListener(e -> {
            stone.clickAbility(kr.masirou.system.Stone.AbilityType.GOOD_ABILITY_1);
            update();
        });
        buttons[1].addActionListener(e -> {
            stone.clickAbility(kr.masirou.system.Stone.AbilityType.GOOD_ABILITY_2);
            update();
        });
        buttons[2].addActionListener(e -> {
            stone.clickAbility(kr.masirou.system.Stone.AbilityType.BAD_ABILITY);
            update();
        });
        buttons[3].addActionListener(e -> {
            stone = new Stone();
            buttons[0].setEnabled(true);
            buttons[1].setEnabled(true);
            buttons[2].setEnabled(true);
            update();
        });


    }

}
