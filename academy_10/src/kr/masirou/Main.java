package kr.masirou;

import kr.masirou.equip.Armor;
import kr.masirou.gui.MainFrame;
import kr.masirou.upgrade.UpgradeManager;
import kr.masirou.util.PercentUtil;

public class Main {
    public static void main(String[] args) {
        Armor armor = new Armor("서리");
        new MainFrame().setEquip(armor);
    }

}