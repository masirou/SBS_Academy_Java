package kr.masirou.patten.strategy.weapons;

import kr.masirou.patten.strategy.Weapon;

public class Sword implements Weapon {

    @Override
    public void attack() {
        System.out.println("칼로 때림");

    }
}
