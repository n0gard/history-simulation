package org.dreaman.society.creature;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.dreaman.society.Dice;

/**
 * 造物主（工厂类）
 * 
 * 
 */
public class CreatureManager {
    private static ConcurrentLinkedQueue<Creature> dyingCreatures = new ConcurrentLinkedQueue<Creature>();

    /**
     * 控制两个生物的生育 <br>
     * 
     * @param c1
     * @param c2
     */
    public static void born(Creature c1, Creature c2) {
        // “产生的后代属于两个部落，这20%里再有20%的会自己成立一个新部落。”-- 王金虎 2013-07-25 11:33:19
        if (c1 instanceof Human && c2 instanceof Human) {
            // 不孕率 35%~40% （发达国家水准。。。）
            if (Dice.judge(1 - ((Math.random() * 5.0 + 35.0) / 100.0))) {
                return;
            }
            // TODO
            Human h1 = (Human) c1;
            Human h2 = (Human) c2;
            Human baby = new Human();
            if (h1.getSex() == Sex.MALE) {
                baby.setFather(h1);
                baby.setMother(h2);
            } else {
                baby.setFather(h2);
                baby.setMother(h1);
            }
        }
    }

    public static void die(Creature c) {
        dyingCreatures.add(c);
    }
}
