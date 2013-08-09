package org.dreaman.society.running;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.dreaman.society.common.DateUtil;
import org.dreaman.society.common.CivilService;
import org.dreaman.society.creature.Human;
import org.dreaman.society.creature.Sex;
import org.dreaman.society.五行.KinghooDate;

public class StartTheWorld {

    static final ExecutorService executor = Executors.newCachedThreadPool();
    public static long runnerSleep = 1000L;

    /**
     * @param args
     */
    public static void main(String[] args) {
        new Thread() {

            @Override
            public void run() {
                super.run();
                while (true) {
                    System.out.println(DateUtil.fullFormat(new Date()) + "\n" + CivilService.LIVING_CREATURES);
                    try {
                        Thread.sleep(5 * 1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }.start();
        // executor.execute(new BearingScheduler());
        executor.execute(new WeatherSystem());

        String[] args2 = {};
        KinghooDate.main(args2);
        new Human(Sex.MALE, "伏羲");
        new Human(Sex.FEMALE, "女娲");
    }

}
