package kr.masirou.gui;

import kr.masirou.equip.Equip;
import kr.masirou.upgrade.UpgradeManager;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Equip equip;
    private JLabel itemNameLabel;
    private JLabel itemGradeLabel;
    private JLabel itemPercentLabel;
    private JButton upgradeButton;
    public MainFrame() {
        this.setSize(500, 500);
        this.setName("강화소");
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        itemNameLabel = new JLabel("현재 아이템 : ");
        itemGradeLabel = new JLabel("현재 강화 수치 :");
        itemPercentLabel = new JLabel("현재 강화 확률 : ");
        itemNameLabel.setBounds(25,10, 460, 150);
        itemNameLabel.setHorizontalAlignment(JLabel.CENTER);
        itemGradeLabel.setBounds(25,80, 460, 150);
        itemGradeLabel.setHorizontalAlignment(JLabel.CENTER);
        itemPercentLabel.setBounds(25,150, 460, 150);
        itemPercentLabel.setHorizontalAlignment(JLabel.CENTER);
        upgradeButton = new JButton("강화");

        upgradeButton.setBounds(200, 300, 100, 50);
        upgradeButton.setHorizontalAlignment(JLabel.CENTER);
        add(upgradeButton);
        add(itemNameLabel);
        add(itemGradeLabel);
        add(itemPercentLabel);
        setEquipLabel();

        upgradeButton.addActionListener(e -> {
            if (equip == null) {
                JOptionPane.showMessageDialog(null, "장비를 선택하지 않았습니다", "Error", JOptionPane.WARNING_MESSAGE);
            }
            else {
                if(UpgradeManager.getInstance().UpgradeItem(equip)) {
                    JOptionPane.showMessageDialog(null, "성공", "성공", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "실패", "실패", JOptionPane.ERROR_MESSAGE);
                }
                setEquipLabel();
            }
        });
    }
    public void setEquip(Equip equip) {
            this.equip = equip;
        setEquipLabel();
    }
    private void setEquipLabel() {
        if (equip == null) {
            itemNameLabel.setText("현재 아이템 : 존재하지 않음");
            itemGradeLabel.setText("현재 강화 수치 : 0강");
            itemPercentLabel.setText("현재 강화 확률 : 0%");
        } else  {
            itemNameLabel.setText("현재 아이템 : " + equip);
            itemGradeLabel.setText("현재 강화 수치 : " + equip.getGrade() + "강");
            itemPercentLabel.setText("현재 강화 확률 : " + UpgradeManager.getInstance().getPercent(equip) + "%");
        }
    }
}
