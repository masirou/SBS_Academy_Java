package kr.masirou.system;

import kr.masirou.util.Percent;

import java.util.Arrays;
import java.util.Optional;

public class Stone {
    private Percent percent;
    private Ability[] abilities;


    public void printInfo() {
        for(Ability ab : abilities) {
            ab.printInfo();
        }
        System.out.println("현재 확률 : " + percent.getPercent() + "%");

    }

    public Stone() {
        percent = new Percent();
        abilities = new Ability[3];
        abilities[0] = new Ability();
        abilities[1] = new Ability();
        abilities[2] = new Ability();

    }
    public int getPercent() {
        return percent.getPercent();
    }
    public Ability getAbility(AbilityType type) {
        return abilities[type.index];
    }
    public boolean ClickAble() {
        for(Ability ab : abilities) {
            if (ab.ClickAble()) return true;
        }
        return false;
    }
    public void clickAbility(AbilityType type) {
        if(abilities[type.index].ClickAble()) {
            abilities[type.index].Click(percent);
        }

    }
    public enum AbilityType {
        GOOD_ABILITY_1(0),
        GOOD_ABILITY_2(1) ,
        BAD_ABILITY(2);

        private int index;
        AbilityType(int index) {
            this.index = index;

        }
        public static AbilityType indexOf(int index) {
            for(AbilityType ab : values()) {
                if (ab.index ==  index) return ab;
            }
            Optional<AbilityType> o = Arrays.stream(values()).filter((a) -> a.index == index).findFirst();
            if(o.isPresent()) return o.get();

            return null;
        }

    }

}
