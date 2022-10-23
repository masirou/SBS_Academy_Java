package kr.masirou.academy;

import kr.masirou.patten.build.Person;
import kr.masirou.patten.build.PersonBuildException;
import kr.masirou.patten.build.PersonBuilder;
import kr.masirou.patten.strategy.Player;
import kr.masirou.patten.strategy.Weapon;
import kr.masirou.patten.strategy.weapons.Sword;

public class Main {
    public static void main(String[] args) throws PersonBuildException {
        Weapon sword = () -> System.out.println("검으로 떄림");

        Player player = new Player();
        player.setWeapon(new Sword());
        player.attack();
    }
}
