package org.dreaman.society.creature;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.dreaman.society.common.DateUtil;
import org.dreaman.society.common.CivilService;
import org.dreaman.society.五行.KinghooDate;
import org.dreaman.society.性格.性格基础;

/**
 * 万物 <br>
 * 基类
 * 
 * 
 */
public class Creature {

    Integer id;
    String name;// 姑且给个名字 人性化一些
    Integer lifetime;// 寿命 （年？天？秒？）
    Date birthday;

    double maxHealth;
    double health;
    double maxPhysical;
    double physical;

    /** 性格池 */
    Set<性格基础> naturePool = new HashSet<性格基础>();

    public Creature() {
        super();
        Date now = new Date();
        // 初始化姓名
        id = CivilService.CREATURES_RECORDS.size() + 1;
        name = id + "";
        // 初始化寿命
        if (this instanceof Human) {
            lifetime = 50 * 1000;
        } else {
            lifetime = 50 * 1000;
        }
        // 初始化生日
        birthday = now;
        KinghooDate wuxingDate = new KinghooDate();
        // 初始化性格
        性格基础 nature = null;
        switch (wuxingDate.getShichen()) {
        case 子:

        }
        naturePool.add(nature);
        // 入档案
        CivilService.CREATURES_RECORDS.put(id, this);
        CivilService.LIVING_CREATURES.put(id, this);
        // 放入生命之池

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLifetime() {
        return lifetime;
    }

    public void setLifetime(Integer lifetime) {
        this.lifetime = lifetime;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getMaxPhysical() {
        return maxPhysical;
    }

    public void setMaxPhysical(double maxPhysical) {
        this.maxPhysical = maxPhysical;
    }

    public double getPhysical() {
        return physical;
    }

    public void setPhysical(double physical) {
        this.physical = physical;
    }

    @Override
    public String toString() {
        return id + "|" + name + "|" + DateUtil.fullFormat(birthday);
    }
}
