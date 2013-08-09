package org.dreaman.society.behavior;

import org.dreaman.society.creature.Creature;
import org.dreaman.society.creature.Human;

public class BehaviorProcess {

    public static void process(Object type, Creature c) {
        if (type instanceof Basic) {
            Basic basic = (Basic) type;
            processBasic(basic, c);
        } else if (type instanceof Advance) {

        }
    }

    private static void processBasic(Basic type, Creature c) {
        switch (type) {
        case eat:
            // TODO 暂且直接补满
            if (c.getHealth() < c.getMaxHealth()) {
                c.setHealth(c.getMaxHealth());
            }
            break;
        case drink:
            // 喝水能有啥作用？

            break;
        case pee:
            // TODO 这个以后用得到吧
            if (c instanceof Human) {
                System.out.println(c.getName() + "解决了三急之一...");
            }
            break;
        case sleep:
            // TODO 暂且直接补满 但状态要改变 否则人人都成布欧了。。。
            if (c.getPhysical() < c.getMaxPhysical()) {
                c.setPhysical(c.getMaxPhysical());
            }
            break;
        default:
            break;
        }
    }
}
