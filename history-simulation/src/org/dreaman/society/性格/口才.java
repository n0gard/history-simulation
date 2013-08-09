package org.dreaman.society.性格;

/**
 * 口才
 * 
 */
public class 口才 extends 性格基础 {

    @Override
    boolean yesOrNo() {
        boolean result = false;
        switch (attribute) {
        // 属水的人 不善言辞
        case 水:
            result = false;
            break;
        // 属火的人 心直口快
        case 火:
            result = true;
            break;
        // 
        case 金:
            break;
        // 
        case 木:
            break;
        // 
        case 土:
            break;
        default:
            break;
        }
        return result;
    }

}
