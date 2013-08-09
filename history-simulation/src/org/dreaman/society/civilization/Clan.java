package org.dreaman.society.civilization;

import java.util.List;

import org.dreaman.society.creature.Human;

/**
 * 部落<br>
 * 以亲情为纽带的团体
 * 
 */
public class Clan {
    // 部落最大人口（用于控制计算量）
    public static long MAX_MEMBERS = 100L;
    private Human elder;// 族长
    private List<Human> clansman; // 族人

    public Human getElder() {
        return elder;
    }

    public void setElder(Human elder) {
        this.elder = elder;
    }

    public List<Human> getClansman() {
        return clansman;
    }

    public void setClansman(List<Human> clansman) {
        this.clansman = clansman;
    }

}
