package kr.masirou.upgrade;

import com.sun.xml.internal.ws.api.message.SuppressAutomaticWSARequestHeadersFeature;
import kr.masirou.equip.Equip;
import kr.masirou.util.PercentUtil;

import java.util.*;

public class UpgradeManager {
    private static UpgradeManager instance;
    public static UpgradeManager getInstance(){
        if (instance == null) instance  = new UpgradeManager();
        return instance;
    }

    private UpgradeManager() {
        otherPercent = Arrays.asList(5.0,2.5,1.0,0.5,0.25,0.1);

    }

    public boolean UpgradeItem(Equip equip) {
        if (PercentUtil.isSuccess(getPercent(equip))) {
            equip.setGrade(equip.getGrade()+1);
            return true;

        }
        else {

            if (equip.getGrade() > 0) {
                equip.setGrade(equip.getGrade()-1);
                return false;

            }
            else {

            }

        }
        System.out.println(equip);
        return true;
    }
    private List<Double> otherPercent;
    public double getPercent(Equip equip) {
        int grade = equip.getGrade();
        if (grade >= 0 && grade <= 8) {
            return 90-(grade*10);
        } else if (grade > 14) {
            return 0.1;
        } else {
            return otherPercent.get(grade-9);
        }


    }
}
