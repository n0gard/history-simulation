package org.dreaman.society.common;

import java.util.Date;

import org.dreaman.society.ganzhi.*;
import org.dreaman.society.wuxing.KinghooDate;

public final class PerfectConstant {
    public static final long 创元 = System.currentTimeMillis();
    public static double speed = 1;

    public static 八字 当前时刻() {
        long now = System.currentTimeMillis();
        long past = 创元 - now;
        return parseMillion2八字(past);
    }

    public static 八字 parseMillion2八字(long periodTime) {
        八字 date = new 八字();
        date.set年干(天干.values()[(int) (periodTime / MILLIONS_PER_YEAR) % 天干.values().length]);
        date.set年支(地支.values()[(int) (periodTime / MILLIONS_PER_YEAR) % 地支.values().length]);
        date.set月干(年上起月表.起月干(date.get年干(), 月份.values()[(int) (periodTime / MILLIONS_PER_MONTH)]));
        date.set月支(年上起月表.起月支(月份.values()[(int) (periodTime / MILLIONS_PER_MONTH)]));
        return date;
    }

    public static KinghooDate parseMillion2KinghooDate(long periodTime) {
        KinghooDate date = new KinghooDate();
        date.setYear((int) (periodTime / MILLIONS_PER_YEAR) + 1);
        date.setMonth((int) ((periodTime / MILLIONS_PER_MONTH) % 每年月数) + 1);
        date.setDay((int) ((periodTime / MILLIONS_PER_DAY) % 每月天数) + 1);
        date.setShichen(地支.values()[(int) ((periodTime / MILLIONS_PER_SHICHEN) % 每天时辰数)]);
        return date;
    }

    public static KinghooDate parseMillion2KinghooDate(Date now) {
        long periodTime = now.getTime() - 创元;
        KinghooDate date = new KinghooDate();
        date.setYear((int) (periodTime / MILLIONS_PER_YEAR) + 1);
        date.setMonth((int) ((periodTime / MILLIONS_PER_MONTH) % 每年月数) + 1);
        date.setDay((int) ((periodTime / MILLIONS_PER_DAY) % 每月天数) + 1);
        date.setShichen(地支.values()[(int) ((periodTime / MILLIONS_PER_SHICHEN) % 每天时辰数)]);
        return date;
    }

    public static long 每年月数 = 地支.values().length;
    public static long 每月天数 = 30;
    public static long 每天时辰数 = 地支.values().length;
    public static long 每时辰秒数 = 2 * 60 * 60;

    public static double MILLIONS_PER_YEAR = (每年月数 * 每月天数 * 每天时辰数 * 每时辰秒数) / speed;
    public static double MILLIONS_PER_MONTH = (每月天数 * 每天时辰数 * 每时辰秒数) / speed;
    public static double MILLIONS_PER_DAY = (每天时辰数 * 每时辰秒数) / speed;
    public static double MILLIONS_PER_SHICHEN = (每时辰秒数) / speed;
}
