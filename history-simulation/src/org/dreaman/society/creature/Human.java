package org.dreaman.society.creature;

import java.util.ArrayList;
import java.util.List;

import org.dreaman.society.Dice;
import org.dreaman.society.civilization.ClanManager;
import org.dreaman.society.common.CNGenerate;
import org.dreaman.society.nature.NatureBase;

/**
 * 人类<br>
 * 个体
 * 
 * 
 */
public class Human extends Creature {
    private Sex sex;
    private Human father;
    private Human mother;
    public static int MIN_BEAR_AGE = 15 * 1000;
    public static int MAX_BEAR_AGE = 25 * 1000;
    private List<NatureBase> natures = new ArrayList<NatureBase>();

    public Human(Sex sex) {
        super();
        this.sex = sex;
        this.name = this.name + "_" + CNGenerate.getChinese();
    }

    /**
     * 指定名字的NPC诞生 如：亚当、夏娃、耶稣、伏羲、女娲。。。。
     * 
     * @param sex
     * @param name
     */
    public Human(Sex sex, String name) {
        super();
        this.sex = sex;
        this.name = name;
    }

    public Human() {
        super();
        this.sex = Dice.judge(0.5) ? Sex.MALE : Sex.FEMALE;
        this.name = this.name + "_" + CNGenerate.getChinese();
    }

    public String fight(Creature c) {
        String log = "";
        if (c instanceof Human) {
            // TODO 和人类战斗
        } else if (c instanceof Plant) {
            // TODO 和植物战斗（？？？）
        }

        return log;
    }

    // 异族通婚被处死的概率
    public static final double DIFF_CLAN_MARRY_DIE_PERCENT = 0.8;

    /**
     * 结婚
     * 
     * @param spouse
     */
    public void marry(Human spouse) {
        if (ClanManager.isSameClan(this, spouse)) {
            if (!Dice.judge(DIFF_CLAN_MARRY_DIE_PERCENT)) {
                CreatureManager.die(this);
                CreatureManager.die(spouse);
            }
        }
    }

    public Sex getSex() {
        return sex;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<NatureBase> getNatures() {
        return natures;
    }

    public void setNatures(List<NatureBase> natures) {
        this.natures = natures;
    }

}
