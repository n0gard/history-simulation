package org.dreaman.society.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateUtil {
    public final static String FORMAT_STANDARD = "yyyy-MM-dd HH:mm:ss";

    private DateUtil() {
    }

    /**
     * 一个月的毫秒数 30 天
     */
    public static final long MONTH_MILLION_SECONDS = 30L * 24L * 60L * 60L * 1000L;

    /**
     * 一天的毫秒数
     */
    public static final long DAY_MILLION_SECONDS = 24L * 60L * 60L * 1000L;

    /**
     * 一个小时的毫秒数
     */
    public static final long HOUR_MILLION_SECONDS = 60L * 60L * 1000L;

    /**
     * 一分钟的毫秒数
     */
    public static final long MINUTE_MILLION_SECONDS = 60L * 1000L;

    /**
     * 一秒的毫秒数
     */
    public static final long MILLOIN_SECONDS = 1000L;

    /**
     * 默认日期转换格式 yyyy-MM-dd HH:mm:ss
     */
    public static final String DEFAULT_DATE_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期转换格式 yyyy-MM-dd
     */
    public static final String DATE_FORMAT_STR = "yyyy-MM-dd";

    /**
     * Linux日期格式
     */
    public static final String DEFAULT_LINUX_DATE_FORMAT_STR = "yyyy_MM_dd_HH_mm_ss";

    /**
     * 加一天，即加24*60*60*1000L毫秒.
     * 
     * @param Date
     *            日期
     * @return Date 参数日期后一天的日期
     */
    public static Date plusOneDay(Date date) {
        return new Date(date.getTime() + 24 * 60 * 60 * 1000L);
    }

    /**
     * 将日期格式化,格式为 yyyy-MM-dd HH:mm:ss
     * 
     * @param Date
     *            日期
     * @return String ：yyyy-MM-dd HH:mm:ss 格式字符串
     */
    public static String fullFormat(Date date) {
        if (null == date) {
            return "";
        }
        DateFormat format = new SimpleDateFormat(DEFAULT_DATE_FORMAT_STR);
        String r = format.format(date);
        return r;
    }

    /**
     * 将日期格式化,格式为 yyyy-MM-dd
     * 
     * @param Date
     *            日期
     * @return String ：yyyy-MM-dd 格式字符串
     */
    public static String simpleFormat(Date date) {
        return date == null ? "" : new SimpleDateFormat(DATE_FORMAT_STR).format(date);
    }

    /**
     * 获取linux环境下的当前时间,格式为 yyyy_MM_dd_HH_mm_ss
     * 
     * @return String ：yyyy_MM_dd_HH_mm_ss 格式字符串
     */
    public static String getLinuxTime() {
        DateFormat format = new SimpleDateFormat(DEFAULT_LINUX_DATE_FORMAT_STR);
        String r = format.format(new Date());
        return r;
    }

    /**
     * 按指定的日期格式、格式化Date
     * 
     * @param date
     *            要格式化的日期
     * @param formatString
     *            想要的格式 如:yyyy-MM-dd
     * @return String ：格式化后的日期
     */
    public static String getFormatDate(Date date, String formatString) {
        DateFormat format = new SimpleDateFormat(formatString);
        String r = format.format(date);
        return r;
    }

    /**
     * 判断时间是否晚于当前时间
     * 
     * @param date
     *            日期
     * @param time
     *            时间 如11:22:21
     * @return boolean : 如果晚于当前时间则返回true， 否则返回false
     * @throws Exception
     */
    public static boolean isAfter(Date date, String time) {
        String obj = date2String(date, DATE_FORMAT_STR);
        if (obj == null) {
            return false;
        }
        StringBuffer b = new StringBuffer(obj);
        b.append(" ").append(time);
        Date in = string2Date(b.toString(), DEFAULT_DATE_FORMAT_STR);
        if (in == null) {
            return false;
        }
        String now = fullFormat(new Date());

        Date nowDate = string2Date(now, DEFAULT_DATE_FORMAT_STR);
        if (in.before(nowDate)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 判断2个日期先后
     * 
     * @param startDate
     *            开始日期
     * @param endDate
     *            结束日期
     * @return boolean: 开始日期在结束日期之前返回true,否则返回false
     */
    public static boolean isBefore(Date startDate, Date endDate) {
        return startDate.before(endDate);
    }

    /**
     * 将字符串转化为 十六进制
     * 
     * @param s
     *            要转化的字符串
     * @return String 转化后的字符串
     */
    public static String toHexString(String s) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String hex = Integer.toHexString(ch);
            str.append(hex);
        }
        return str.toString();
    }

    /**
     * 将毫秒转化为时间,转化的时间单位精确到分钟
     * 
     * @param m
     *            要转化的毫秒
     * @return String 转化后的时间 如： 1年2月3天4小时5分6秒
     */
    public static String toPeriodTime(long m) {
        StringBuffer sb = new StringBuffer();
        long yearMillionSeconds = 365L * 24L * 60L * 60L * 1000L;
        long years = m / yearMillionSeconds;
        m = m - years * yearMillionSeconds;
        long months = m / MONTH_MILLION_SECONDS;
        m = m - months * MONTH_MILLION_SECONDS;
        long days = m / DAY_MILLION_SECONDS;
        m = m - days * DAY_MILLION_SECONDS;
        long hours = m / HOUR_MILLION_SECONDS;
        m = m - hours * HOUR_MILLION_SECONDS;
        long minutes = m / MINUTE_MILLION_SECONDS;
        m = m - minutes * MINUTE_MILLION_SECONDS;
        long seconds = m / MILLOIN_SECONDS;
        if (0 != years) {
            sb.append(String.valueOf(years));
            sb.append("年");
        }
        if (0 != months) {
            sb.append(String.valueOf(months));
            sb.append("月");
        }
        if (0 != days) {
            sb.append(String.valueOf(days));
            sb.append("天");
        }
        if (0 != hours) {
            sb.append(String.valueOf(hours));
            sb.append("小时");
        }
        if (0 != minutes) {
            sb.append(String.valueOf(minutes));
            sb.append("分");
        }
        if (0 != seconds) {
            sb.append(String.valueOf(seconds));
            sb.append("秒");
        }
        return sb.toString();
    }

    /**
     * 将String转化为Date类型
     * 
     * @param str
     *            要转化的字符串
     * @param format
     *            要转化的格式 如 :yyyy-MM-dd HH:mm:ss
     * @return Date: 转化后的日期
     */
    public static Date string2Date(String str, String format) {
        if (null == str || "".equals(str.trim())) {
            return null;
        }
        DateFormat df = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = df.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将Date 转化为 String
     * 
     * @param date
     *            要转化的日期
     * @param format
     *            要转化的格式 如 :yyyy-MM-dd HH:mm:ss
     * @return String: 转化后的日期
     * @throws Exception
     */
    public static String date2String(Date date, String format) {
        if (date == null || format == null) {
            return null;
        }

        DateFormat df = new SimpleDateFormat(format);

        return df.format(date);
    }

    /**
     * 比较两个日期相差的天数
     * 
     * @param time1
     *            日期1 格式: yyyy-MM-dd
     * @param time2
     *            日期2 格式: yyyy-MM-dd
     * @return long ： 返回相差的天数
     */
    public static long getQuot(String time1, String time2) {
        long quot = 0;
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = ft.parse(time1);
            Date date2 = ft.parse(time2);
            quot = date1.getTime() - date2.getTime();
            quot = quot / 1000 / 60 / 60 / 24;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quot;
    }

    /**
     * 根据日期计算所在周的周一和周日
     * 
     * @param time
     *            指定的日期
     * @throws Exception
     * @return 周一和周日的日期
     */
    public static String[] getWeekdays(String day) throws Exception {
        Date time = string2Date(day, "yyyy-MM-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int dayInWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - dayInWeek);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        String imptimeBegin = sdf.format(cal.getTime());
        // System.out.println("所在周星期一的日期：" + imptimeBegin);
        cal.add(Calendar.DATE, 6);
        String imptimeEnd = sdf.format(cal.getTime());
        // System.out.println("所在周星期日的日期：" + imptimeEnd);
        String[] result = { imptimeBegin, imptimeEnd };

        return result;
    }

    /**
     * 获取某一天所在月的第一天和最后一天
     * 
     * @param checkTime
     * @return
     * @throws Exception
     */
    public static String[] getMonthdays(String checkTime) throws Exception {
        String[] strArray = checkTime.split("-");
        String startDate = strArray[0] + "-" + strArray[1] + "-01";
        String temp = strArray[0] + "-" + (Integer.parseInt(strArray[1]) + 1) + "-01";
        Date endDate = new Date(string2Date(temp, "yyyy-MM-dd").getTime() - 24 * 60 * 60 * 1000L);
        String[] result = { startDate, date2String(endDate, "yyyy-MM-dd") };
        return result;
    }

    /**
     * 根据日期获取整年的第一天和最后一天
     * 
     * @param checkTime
     * @return
     */
    public static String[] getYeardays(String checkTime) {
        String year = checkTime.split("-")[0];
        String firstDay = year + "-01-01";
        String lastDay = year + "-12-31";
        String[] result = { firstDay, lastDay };
        return result;
    }

    public static Date getNextDay(Date date) {
        if (null == date) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        c.add(Calendar.DATE, 1);
        return c.getTime();
    }

    /**
     * 根据当前日期获取当天最后一秒的时间
     * 
     * @param date
     * @return XX-XX-XX 23:59:59
     */
    public static Date getLastSecond(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        c.add(Calendar.DATE, 1);
        c.add(Calendar.SECOND, -1);
        return c.getTime();
    }

    /**
     * 获取当天零时
     * 
     * @throws Exception
     */
    public static Date getTodayDate(Date date) throws Exception {
        String dateStr = date2String(date, "yyyy-MM-dd");
        return DateUtil.string2Date(dateStr, "yyyy-MM-dd");

    }

    /**
     * 将long型的毫秒数转化为对应的时间，如1000毫秒为1秒，最小单位为秒，最大单位为天
     * 
     * @return 时间的字符串
     */
    public static String parseTime2Str(long time) {
        long dayTime = 24 * 60 * 60 * 1000;
        long hourTime = 60 * 60 * 1000;
        long minTime = 60 * 1000;
        long secTime = 1000;

        long day = time / dayTime;
        long hour = time % dayTime / hourTime;
        long min = time % dayTime % hourTime / minTime;
        long sec = time % dayTime % hourTime % minTime / secTime;

        long[] values = new long[] { day, hour, min, sec };
        String[] units = new String[] { "天", "小时", "分钟", "秒" };
        StringBuffer result = new StringBuffer();
        int firstNotZero = 3;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > 0) {
                firstNotZero = i;
                break;
            }
        }

        for (int i = firstNotZero; i < values.length; i++) {
            result.append(String.valueOf(values[i]) + units[i]);
        }
        return result.toString();
    }

    /**
     * longToShort 将长格式的日期转换成短格式的日期（如将”yyyy-MM-dd HH:mm:ss" 转换成”yyyy-MM-dd“）
     * 
     * @param dateSource
     * @return
     * @author ma.zhiyong
     * @createTime： Jun 13, 2012 -- 3:50:58 PM
     */
    public static Date longToShort(Date dateSource) {
        String sourceString = date2String(dateSource, DEFAULT_DATE_FORMAT_STR);
        Date date = string2Date(sourceString, DATE_FORMAT_STR);
        return date;
    }

    public static String getDateTime(Calendar cal) {
        Date date = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(date);
    }

    public static Date long2Date(String time) {
        Long l = Long.valueOf(time) * 1000l;
        Date date = new Date(l);
        return date;
    }

    /**
     * 计算指定日期改变多少天后的日期
     * 
     * @param date
     *            指定日期
     * @param days
     *            天数 正数为指定日期之后 负数为指定日期之前
     * @return 计算后的日期 格式yyyy-MM-dd
     */
    public static String changeDays(Date date, Integer days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + days);// 让日期加1
        return date2String(calendar.getTime(), DateUtil.DATE_FORMAT_STR);
    }

    public static String changeDays(Date date, Integer days, String format) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + days);// 让日期加1
        return date2String(calendar.getTime(), format);
    }

    public static String getNextDay(String date, Integer day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(string2Date(date, DateUtil.DATE_FORMAT_STR));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + day);// 让日期加1
        return date2String(calendar.getTime(), DateUtil.DATE_FORMAT_STR);
    }

}
