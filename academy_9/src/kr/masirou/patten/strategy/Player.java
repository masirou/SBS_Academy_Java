package kr.masirou.patten.strategy;

public class Player {
    private Weapon weapon;
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public  void  attack() {
        if (weapon == null) System.out.println("무기가 없음");
        else weapon.attack();
    }
}
