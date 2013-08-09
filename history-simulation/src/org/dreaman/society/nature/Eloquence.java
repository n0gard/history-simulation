package org.dreaman.society.nature;

/**
 * 口才
 * 
 */
public class Eloquence extends NatureBase {

    @Override
    boolean yesOrNo() {
        boolean result = false;
        switch (attribute) {
        case 水:
            result = false;
            break;
        case 火:
            result = true;
            break;
        case 金:
            break;
        case 木:
            break;
        case 土:
            break;
        default:
            break;
        }
        return result;
    }

}
