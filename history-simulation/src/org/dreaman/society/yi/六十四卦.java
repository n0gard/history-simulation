package org.dreaman.society.yi;

import java.util.Date;

public enum 六十四卦 {
    乾卦(卦.乾天, 卦.乾天), ;
    private String name;
    private 卦 upGua;
    private 卦 bottomGua;

    /**
     * 卜卦
     * 
     * @param now
     * @return
     */
    public static 六十四卦 generate(Date now) {
        long seed = now.getTime();
        int index = (int) seed % 64;
        return values()[index];
    }

    private 六十四卦(卦 upGua, 卦 bottomGua) {
        this.upGua = upGua;
        this.bottomGua = bottomGua;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public 卦 getUpGua() {
        return upGua;
    }

    public void setUpGua(卦 upGua) {
        this.upGua = upGua;
    }

    public 卦 getBottomGua() {
        return bottomGua;
    }

    public void setBottomGua(卦 bottomGua) {
        this.bottomGua = bottomGua;
    }

}
