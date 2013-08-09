package org.dreaman.society.common;

import java.util.*;

public class CNGenerate {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Random r = new Random(new Date().getTime() + 100);
        System.out.println(r.nextInt(10000));
        System.out.println("生成的汉字为：" + getChinese());

    }

    public static String getChinese() {
        Random random = new Random();
        String ctmp = "";
        String[] rBase = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
        // 生成第一位区码
        int r1 = random.nextInt(3) + 11;
        String str_r1 = rBase[r1];

        // 生成第二位区码
        int r2;
        if (r1 == 13) {
            r2 = random.nextInt(7);
        } else {
            r2 = random.nextInt(16);
        }
        String str_r2 = rBase[r2];
        // 第三位的位码
        int r3 = random.nextInt(6) + 10;
        String str_r3 = rBase[r3];
        // 第四位的位码
        int r4;
        if (r3 == 10) {
            r4 = random.nextInt(15) + 1;
        } else if (r3 == 15) {
            r4 = random.nextInt(15);
        } else {
            r4 = random.nextInt(16);
        }
        String str_r4 = rBase[r4];

        byte[] bytes = new byte[2]; // 定义二维数组，用以保存汉字
        String str_r12 = str_r1 + str_r2;
        int tempLow = Integer.parseInt(str_r12, 16);
        bytes[0] = (byte) tempLow;

        String str_r34 = str_r3 + str_r4;
        int tempHigh = Integer.parseInt(str_r34, 16);
        bytes[1] = (byte) tempHigh;

        ctmp = new String(bytes);

        return ctmp;
    }
}
