package org.dreaman.society.yi;

public enum 卦 {
    乾天(爻.阳, 爻.阳, 爻.阳), 兑泽(爻.阴, 爻.阳, 爻.阳);

    private String name;
    private 爻 topYao;
    private 爻 middleYao;
    private 爻 bottomYao;

    private 卦(爻 topYao, 爻 middleYao, 爻 bottomYao) {
        this.topYao = topYao;
        this.middleYao = middleYao;
        this.bottomYao = bottomYao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public 爻 getTopYao() {
        return topYao;
    }

    public void setTopYao(爻 topYao) {
        this.topYao = topYao;
    }

    public 爻 getMiddleYao() {
        return middleYao;
    }

    public void setMiddleYao(爻 middleYao) {
        this.middleYao = middleYao;
    }

    public 爻 getBottomYao() {
        return bottomYao;
    }

    public void setBottomYao(爻 bottomYao) {
        this.bottomYao = bottomYao;
    }

}
