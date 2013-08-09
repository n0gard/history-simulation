package org.dreaman.society.running;

import java.util.Date;

import org.dreaman.society.common.PerfectConstant;
import org.dreaman.society.enviroment.Weather;
import org.dreaman.society.wuxing.KinghooDate;
import org.dreaman.society.wuxing.MoonPhase;
import org.dreaman.society.wuxing.SunPhase;
import org.dreaman.society.wuxing.五行;

public class WeatherSystem implements Runnable {

    public static Weather currentWeather;

    @Override
    public void run() {
        while (true) {
            Date now = new Date();
            KinghooDate date = PerfectConstant.parseMillion2KinghooDate(now);
            五行 jinri = MoonPhase.currentDay五行(now);
            五行 shichen = SunPhase.currentShichen五行(now);
            if (五行.水 == jinri && 五行.水 == shichen) {
                if (date.getMonth() > 11 || date.getMonth() < 3) {
                    currentWeather = Weather.雪;
                } else {
                    currentWeather = Weather.雨;
                }
            } else if (五行.火 == jinri && 五行.火 == shichen) {
                currentWeather = Weather.晴;
            } else {
                currentWeather = Weather.云;
            }
            try {
                Thread.sleep((long) PerfectConstant.MILLIONS_PER_SHICHEN);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
