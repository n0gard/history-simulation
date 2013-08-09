package org.dreaman.society.wuxing;

import java.util.Date;

import org.dreaman.society.common.PerfectConstant;
import org.dreaman.society.ganzhi.地支;

public class SunPhase {
    public static 五行 currentShichen五行(long periodTime) {
        五行 current = null;
        KinghooDate date = PerfectConstant.parseMillion2KinghooDate(periodTime);
        地支 shichen = date.getShichen();
        switch (shichen) {
        // 阴
        case 子:
            current = 五行.水;
            break;
        // 阴 ——> 阳
        case 丑:
        case 寅:
        case 辰:
        case 巳:
            current = 五行.木;
            break;
        // 阳 ——> 阴
        case 未:
        case 申:
        case 戌:
        case 亥:
            current = 五行.金;
            break;
        // 阴阳平衡
        case 卯:
        case 酉:
            current = 五行.土;
            break;
        // 阳
        case 午:
            current = 五行.火;
            break;
        default:
            break;
        }
        return current;
    }

    public static 五行 currentShichen五行(Date now) {
        五行 current = null;
        KinghooDate date = PerfectConstant.parseMillion2KinghooDate(now.getTime() - PerfectConstant.创元);
        地支 shichen = date.getShichen();
        switch (shichen) {
        // 阴
        case 子:
            current = 五行.水;
            break;
        // 阴 ——> 阳
        case 丑:
        case 寅:
        case 辰:
        case 巳:
            current = 五行.木;
            break;
        // 阳 ——> 阴
        case 未:
        case 申:
        case 戌:
        case 亥:
            current = 五行.金;
            break;
        // 阴阳平衡
        case 卯:
        case 酉:
            current = 五行.土;
            break;
        // 阳
        case 午:
            current = 五行.火;
            break;
        default:
            break;
        }
        return current;
    }
}
