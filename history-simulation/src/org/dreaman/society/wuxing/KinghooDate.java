package org.dreaman.society.wuxing;

import java.util.Date;

import org.dreaman.society.common.PerfectConstant;
import org.dreaman.society.ganzhi.地支;
import org.dreaman.society.running.WeatherSystem;

public class KinghooDate {
    private int year;
    private int month;
    private int day;
    private 地支 shichen;

    public KinghooDate() {
        Date now = new Date();
        long periodTime = now.getTime() - PerfectConstant.创元;
        this.year = ((int) (periodTime / PerfectConstant.MILLIONS_PER_YEAR) + 1);
        this.month = ((int) ((periodTime / PerfectConstant.MILLIONS_PER_MONTH) % PerfectConstant.每年月数) + 1);
        this.day = ((int) ((periodTime / PerfectConstant.MILLIONS_PER_DAY) % PerfectConstant.每月天数) + 1);
        this.shichen = (地支.values()[(int) ((periodTime / PerfectConstant.MILLIONS_PER_SHICHEN) % PerfectConstant.每天时辰数)]);
    }

    public KinghooDate(Date now) {
        long periodTime = now.getTime();
        this.year = ((int) (periodTime / PerfectConstant.MILLIONS_PER_YEAR) + 1);
        this.month = ((int) ((periodTime / PerfectConstant.MILLIONS_PER_MONTH) % PerfectConstant.每年月数) + 1);
        this.day = ((int) ((periodTime / PerfectConstant.MILLIONS_PER_DAY) % PerfectConstant.每月天数) + 1);
        this.shichen = (地支.values()[(int) ((periodTime / PerfectConstant.MILLIONS_PER_SHICHEN) % PerfectConstant.每天时辰数)]);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public 地支 getShichen() {
        return shichen;
    }

    public void setShichen(地支 shichen) {
        this.shichen = shichen;
    }

    @Override
    public String toString() {
        return year + "年" + month + "月" + day + "日" + shichen + "时";
    }

    public KinghooDate passDays(KinghooDate date) {
        KinghooDate diffDate = new KinghooDate();
        int day = this.day;
        int month = this.month;
        int year = this.year;

        int deltaShichen = this.shichen.ordinal() - date.getShichen().ordinal();
        if (deltaShichen < 0) {
            day--;
            deltaShichen = deltaShichen + 地支.values().length;
        }
        diffDate.setShichen(地支.values()[deltaShichen]);

        int deltaDay = day - date.getDay();
        if (deltaDay < 0) {
            month--;
            deltaDay = deltaDay + (int) PerfectConstant.每月天数;
        }
        diffDate.setDay(deltaDay);

        int deltaMonth = month - date.getMonth();
        if (deltaMonth < 0) {
            year--;
            deltaMonth = deltaMonth + (int) PerfectConstant.每年月数;
        }
        diffDate.setMonth(deltaMonth);
        diffDate.setYear(year - date.getYear());
        return diffDate;
    }

    public static void main(String[] args) {
        System.out.println(new KinghooDate());
    }

    public static void test1() throws InterruptedException {
        long last = 0;
        KinghooDate lastDate = null;
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(1000);
            long passed = System.currentTimeMillis() - PerfectConstant.创元;
            KinghooDate now = PerfectConstant.parseMillion2KinghooDate(passed);
            if (null != lastDate)
                System.out.println(now + "\t" + MoonPhase.currentDay五行(passed) + "\t"
                        + SunPhase.currentShichen五行(passed) + "\t" + WeatherSystem.currentWeather + "\t过了"
                        + now.passDays(lastDate) + "虚拟时间\t过了" + (passed - last) + "现实毫秒\t共经过了" + (passed) + "现实毫秒\t速度 "
                        + PerfectConstant.speed + "x");
            if (0 == i % 50) {
                PerfectConstant.speed = PerfectConstant.speed * 10;
            }
            if (0 == i % 5) {
                System.out.println(PerfectConstant.MILLIONS_PER_SHICHEN);
            }
            last = passed;
            lastDate = now;
        }
    }
}
