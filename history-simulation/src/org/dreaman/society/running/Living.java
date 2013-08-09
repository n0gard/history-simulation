package org.dreaman.society.running;

import org.dreaman.society.creature.Creature;
import org.dreaman.society.ganzhi.地支;
import org.dreaman.society.wuxing.KinghooDate;

public class Living implements Runnable {

    private Creature c;

    Living(Creature c) {
        this.c = c;
    }

    public Creature getC() {
        return c;
    }

    public void setC(Creature c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            KinghooDate now = new KinghooDate();
            地支 shichen = now.getShichen();

            switch (shichen) {
            // 睡觉时间
            case 戌:
            case 亥:
            case 子:
            case 丑:
            case 寅:
            case 卯:
                sleep(now);
                break;
            // 早上的活动时间
            case 辰:
            case 巳:
                break;
            // 午休时间
            case 午:
                break;
            // 下午的活动时间
            case 未:
            case 申:
            case 酉:
                break;
            // 其他
            default:
                break;
            }
        }
    }

    private void sleep(KinghooDate now) {
        // 睡觉恢复健康

        double increasePoint = c.getMaxHealth() * 0.01;
        double afterIncreasementHealth = c.getHealth() + increasePoint;
        if (afterIncreasementHealth > c.getMaxHealth()) {
            c.setHealth(c.getMaxHealth());
        } else {
            c.setHealth(afterIncreasementHealth);
        }
    }
}