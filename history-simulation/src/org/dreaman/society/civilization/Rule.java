package org.dreaman.society.civilization;

/**
 * 基本规则 生存之道 <br>
 * 所有规则的父类
 */
public class Rule {
    private Integer id;
    private String name;
    private String target;
    private String description;

    public boolean rightOrWrong() {
        if (Math.random() > 0.5) {
            return true;
        }
        return false;
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

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
