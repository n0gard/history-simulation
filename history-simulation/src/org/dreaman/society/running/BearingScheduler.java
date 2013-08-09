package org.dreaman.society.running;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.dreaman.society.Dice;
import org.dreaman.society.common.CivilService;
import org.dreaman.society.creature.Creature;
import org.dreaman.society.creature.CreatureManager;
import org.dreaman.society.creature.Human;
import org.dreaman.society.creature.Sex;

public class BearingScheduler implements Runnable {

    ConcurrentHashMap<Long, Human> bearing = new ConcurrentHashMap<Long, Human>();

    @Override
    public void run() {
        while (true) {
            long now = System.currentTimeMillis();
            try {
                Thread.sleep(StartTheWorld.runnerSleep);
                // 将坐完月子的剔除
                for (long t : bearing.keySet()) {
                    if (now - t > 2 * 1000) {
                        bearing.remove(t);
                    }
                }

                for (Creature c : CivilService.CREATURES_RECORDS.values()) {
                    // 寿终
                    if (now - c.getBirthday().getTime() > c.getLifetime()) {
                        CivilService.LIVING_CREATURES.remove(c.getId());
                        continue;
                    }
                    // 意外
                    if (!Dice.judge(0.00002)) {
                        CivilService.LIVING_CREATURES.remove(c.getId());
                        continue;
                    }
                }

                // 筛选出可以生育的
                List<Human> bearPoolMale = new ArrayList<Human>();
                List<Human> bearPoolFemale = new ArrayList<Human>();
                for (Creature c : CivilService.LIVING_CREATURES.values()) {
                    // 排除正在生育的
                    if (bearing.containsValue(c)) {
                        continue;
                    }
                    if (c instanceof Human) {
                        // 育龄暂且男女都一样
                        if (now - c.getBirthday().getTime() > Human.MIN_BEAR_AGE
                                && now - c.getBirthday().getTime() < Human.MAX_BEAR_AGE) {
                            Human h = (Human) c;
                            if (h.getSex() == Sex.MALE) {
                                bearPoolMale.add(h);
                            } else {
                                bearPoolFemale.add(h);
                            }
                        }
                    }
                }
                // 自由繁殖（随机，无情感的）
                while (true) {
                    if (bearPoolMale.size() == 0 || bearPoolFemale.size() == 0) {
                        break;
                    }
                    int seed = bearPoolMale.size();
                    int index = (int) (Math.random() * (double) seed);
                    Human h1 = bearPoolMale.get(index);
                    bearPoolMale.remove(index);
                    seed = bearPoolFemale.size();
                    index = (int) (Math.random() * (double) seed);
                    Human h2 = bearPoolFemale.get(index);
                    bearPoolFemale.remove(index);

                    CreatureManager.born(h1, h2);
                    bearing.put(now, h2);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
