package org.dreaman.society.五行;

import java.util.Date;

import org.dreaman.society.common.PerfectConstant;

public class MoonPhase {
    public static 五行 currentDay五行(long periodTime) {
        五行 current = null;
        KinghooDate date = PerfectConstant.parseMillion2KinghooDate(periodTime);
        int day = date.getDay();
        switch (day) {
        // 阴
        case 1:
        case 2:
        case 3:
        case 28:
        case 29:
        case 30:
            current = 五行.水;
            break;
        // 阴 ——> 阳
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
            current = 五行.木;
            break;
        // 阳 ——> 阴
        case 27:
        case 26:
        case 25:
        case 24:
        case 23:
        case 22:
            current = 五行.金;
            break;
        // 阴阳平衡
        case 10:
        case 11:
        case 12:
        case 19:
        case 20:
        case 21:
            current = 五行.土;
            break;
        // 阳
        case 13:
        case 14:
        case 15:
        case 16:
        case 17:
        case 18:
            current = 五行.火;
            break;
        default:
            break;
        }
        return current;
    }

    public static 五行 currentDay五行(Date now) {
        五行 current = null;
        KinghooDate date = PerfectConstant.parseMillion2KinghooDate(now.getTime() - PerfectConstant.创元);
        int day = date.getDay();
        switch (day) {
        // 阴
        case 1:
        case 2:
        case 3:
        case 28:
        case 29:
        case 30:
            current = 五行.水;
            break;
        // 阴 ——> 阳
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
            current = 五行.木;
            break;
        // 阳 ——> 阴
        case 27:
        case 26:
        case 25:
        case 24:
        case 23:
        case 22:
            current = 五行.金;
            break;
        // 阴阳平衡
        case 10:
        case 11:
        case 12:
        case 19:
        case 20:
        case 21:
            current = 五行.土;
            break;
        // 阳
        case 13:
        case 14:
        case 15:
        case 16:
        case 17:
        case 18:
            current = 五行.火;
            break;
        default:
            break;
        }
        return current;
    }
}
